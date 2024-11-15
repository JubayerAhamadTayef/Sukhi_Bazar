package com.jubayer_ahamad_tayef.domain.network

import com.jubayer_ahamad_tayef.domain.model.Product

interface NetworkService {

    suspend fun getProducts(category: String?): ResultWrapper<List<Product>>

    suspend fun getCategories(): ResultWrapper<List<String>>
}

sealed class ResultWrapper<out T> {

    data class Success<out T>(val value: T) : ResultWrapper<T>()

    data class Failure(val exception: Exception) : ResultWrapper<Nothing>()
}