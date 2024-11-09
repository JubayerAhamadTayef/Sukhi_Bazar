package com.jubayer_ahamad_tayef.sukhi_bazar.ui.feature.home // Defines the package for the home feature UI components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jubayer_ahamad_tayef.domain.model.Product
import com.jubayer_ahamad_tayef.domain.network.ResultWrapper
import com.jubayer_ahamad_tayef.domain.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel for the Home screen
class HomeViewModel(private val getProductUseCase: GetProductUseCase) : ViewModel() {

    // MutableStateFlow to manage the UI state
    private val _uiState = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)
    val uiState = _uiState.asStateFlow() // Public read-only state flow

    init {
        // Initiates the product fetching process when the ViewModel is created
        getProducts()
    }

    // Function to fetch products
    private fun getProducts() {
        viewModelScope.launch {
            _uiState.value = HomeScreenUIEvents.Loading // Set UI state to loading
            getProductUseCase.execute().let { result -> // Execute use case to fetch products
                when (result) {
                    is ResultWrapper.Success -> {
                        val data = (result).value // Retrieve data from the result
                        _uiState.value =
                            HomeScreenUIEvents.Success(data) // Update UI state with success
                    }

                    is ResultWrapper.Failure -> {
                        val errorMessage =
                            (result).exception.message
                                ?: "An error occurred" // Retrieve error message
                        _uiState.value =
                            HomeScreenUIEvents.Error(errorMessage) // Update UI state with error
                    }
                }
            }
        }
    }
}

// UI events for the Home screen
sealed class HomeScreenUIEvents {
    data object Loading : HomeScreenUIEvents() // Represents a loading state
    data class Success(val data: List<Product>) :
        HomeScreenUIEvents() // Represents a success state with data

    data class Error(val message: String) :
        HomeScreenUIEvents() // Represents an error state with a message
}