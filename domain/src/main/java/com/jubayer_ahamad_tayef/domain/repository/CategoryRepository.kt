package com.jubayer_ahamad_tayef.domain.repository

import com.jubayer_ahamad_tayef.domain.network.ResultWrapper

interface CategoryRepository {

    suspend fun getCategories(): ResultWrapper<List<String>>

}