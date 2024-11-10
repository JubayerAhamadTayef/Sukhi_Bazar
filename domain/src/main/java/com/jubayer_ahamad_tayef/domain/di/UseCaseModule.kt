package com.jubayer_ahamad_tayef.domain.di

import com.jubayer_ahamad_tayef.domain.usecase.GetCategoryUseCase
import com.jubayer_ahamad_tayef.domain.usecase.GetProductUseCase
import org.koin.dsl.module // Importing Koin's module function for creating DI modules

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoryUseCase(get()) }
}