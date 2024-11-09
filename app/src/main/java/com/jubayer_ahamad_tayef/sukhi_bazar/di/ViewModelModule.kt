package com.jubayer_ahamad_tayef.sukhi_bazar.di // Package for dependency injection setup

import com.jubayer_ahamad_tayef.sukhi_bazar.ui.feature.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

// Define the Koin module for ViewModel dependencies
val viewModelModule = module {
    // Provide the HomeViewModel dependency using Koin's viewModel function
    // 'get()' resolves the required dependencies that HomeViewModel needs
    viewModel { HomeViewModel(get()) }
}