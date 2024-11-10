package com.jubayer_ahamad_tayef.data.di

import com.jubayer_ahamad_tayef.data.repository.CategoryRepositoryImpementation
import com.jubayer_ahamad_tayef.data.repository.ProductRepositoryImplementation
import com.jubayer_ahamad_tayef.domain.repository.CategoryRepository
import com.jubayer_ahamad_tayef.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImplementation(get()) }

    single<CategoryRepository> { CategoryRepositoryImpementation(get()) }
}