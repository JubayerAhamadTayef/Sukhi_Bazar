package com.jubayer_ahamad_tayef.domain.network // Package for network-related interfaces and result handling

import com.jubayer_ahamad_tayef.domain.model.Product

// Interface for network service operations
interface NetworkService {
    // Suspended function to fetch products, optionally filtered by category
    suspend fun getProducts(category: String?): ResultWrapper<List<Product>>
}

// Sealed class to handle results of network operations
sealed class ResultWrapper<out T> {
    // Success result containing the value of type T
    data class Success<out T>(val value: T) : ResultWrapper<T>()

    // Failure result containing an exception
    data class Failure(val exception: Exception) : ResultWrapper<Nothing>()
}