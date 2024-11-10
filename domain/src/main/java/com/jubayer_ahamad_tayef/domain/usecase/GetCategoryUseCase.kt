package com.jubayer_ahamad_tayef.domain.usecase

import com.jubayer_ahamad_tayef.domain.repository.CategoryRepository

class GetCategoryUseCase(private val repository: CategoryRepository) {
    suspend fun execute() = repository.getCategories()
}