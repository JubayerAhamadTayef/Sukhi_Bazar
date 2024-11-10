package com.jubayer_ahamad_tayef.data.repository

import com.jubayer_ahamad_tayef.domain.network.NetworkService
import com.jubayer_ahamad_tayef.domain.network.ResultWrapper
import com.jubayer_ahamad_tayef.domain.repository.CategoryRepository

class CategoryRepositoryImpementation(val networkService: NetworkService) : CategoryRepository {
    override suspend fun getCategories(): ResultWrapper<List<String>> {
        return networkService.getCategories()
    }
}