package com.jubayer_ahamad_tayef.sukhi_bazar.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jubayer_ahamad_tayef.domain.model.Product
import com.jubayer_ahamad_tayef.domain.network.ResultWrapper
import com.jubayer_ahamad_tayef.domain.usecase.GetCategoryUseCase
import com.jubayer_ahamad_tayef.domain.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductUseCase: GetProductUseCase,
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch {
            _uiState.value = HomeScreenUIEvents.Loading
            val features = getProducts("electronics")
            val popularProducts = getProducts("jewelery")
            val categories = getCategory()
            if (features.isEmpty() && popularProducts.isEmpty() && categories.isNotEmpty()) {
                _uiState.value = HomeScreenUIEvents.Error("Failed to load products")
                return@launch
            }
            _uiState.value = HomeScreenUIEvents.Success(features, popularProducts, categories)
        }
    }

    private suspend fun getCategory(): List<String> {
        getCategoryUseCase.execute().let { result ->
            when (result) {
                is ResultWrapper.Success -> {
                    return (result).value
                }

                is ResultWrapper.Failure -> {
                    return emptyList()
                }
            }
        }
    }

    private suspend fun getProducts(category: String?): List<Product> {
        getProductUseCase.execute(category).let { result ->
            when (result) {
                is ResultWrapper.Success -> {
                    return (result).value
                }

                is ResultWrapper.Failure -> {
                    return emptyList()
                }
            }
        }
    }
}

sealed class HomeScreenUIEvents {
    data object Loading : HomeScreenUIEvents()
    data class Success(
        val features: List<Product>,
        val popularProducts: List<Product>,
        val categories: List<String>
    ) : HomeScreenUIEvents()

    data class Error(val message: String) : HomeScreenUIEvents()
}