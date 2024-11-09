package com.jubayer_ahamad_tayef.data.network // Package for network-related classes and functions

import com.jubayer_ahamad_tayef.data.model.DataProductModel
import com.jubayer_ahamad_tayef.domain.model.Product
import com.jubayer_ahamad_tayef.domain.network.NetworkService
import com.jubayer_ahamad_tayef.domain.network.ResultWrapper
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException

// Implementation of NetworkService interface using Ktor HttpClient
class NetworkServiceImplementation(val client: HttpClient) : NetworkService {

    private val baseUrl = "https://fakestoreapi.com"

    // Fetches products from the API and maps them to the domain model
    override suspend fun getProducts(category: String?): ResultWrapper<List<Product>> {
        // Constructs the URL based on the optional category parameter
        val url =
            if (category != null) "$baseUrl/products/category/$category" else "$baseUrl/products"

        return makeWebRequest(
            url = url,
            method = HttpMethod.Get,
            mapper = { dataModules: List<DataProductModel> ->
                dataModules.map { it.toProduct() } // Map API response to domain model
            })
    }

    // Generic function to make web requests and handle responses
    suspend inline fun <reified T, R> makeWebRequest(
        url: String,
        method: HttpMethod,
        body: Any? = null,
        headers: Map<String, String> = emptyMap(),
        parameters: Map<String, String> = emptyMap(),
        noinline mapper: ((T) -> R)? = null
    ): ResultWrapper<R> {
        return try {
            // Make an HTTP request using the specified parameters
            val response = client.request(url) {
                this.method = method
                // Apply query parameters
                url {
                    this.parameters.appendAll(Parameters.build {
                        parameters.forEach { (key, value) ->
                            append(key, value)
                        }
                    })
                }
                // Apply headers
                headers.forEach { (key, value) ->
                    header(key, value)
                }
                // Set body for methods like POST, PUT, etc.
                if (body != null) {
                    setBody(body)
                }
                // Set content type to JSON
                contentType(ContentType.Application.Json)
            }.body<T>()
            // Map response using the provided mapper or cast directly
            val result: R = mapper?.invoke(response) ?: response as R
            ResultWrapper.Success(result)
        } catch (e: ClientRequestException) {
            ResultWrapper.Failure(e) // Handle client request errors (4xx)
        } catch (e: ServerResponseException) {
            ResultWrapper.Failure(e) // Handle server response errors (5xx)
        } catch (e: IOException) {
            ResultWrapper.Failure(e) // Handle IO errors
        } catch (e: Exception) {
            ResultWrapper.Failure(e) // Handle any other exceptions
        }
    }
}