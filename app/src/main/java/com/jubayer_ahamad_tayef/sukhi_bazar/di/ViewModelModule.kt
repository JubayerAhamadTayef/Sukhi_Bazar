package com.jubayer_ahamad_tayef.sukhi_bazar.di

import com.jubayer_ahamad_tayef.sukhi_bazar.ui.feature.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
}