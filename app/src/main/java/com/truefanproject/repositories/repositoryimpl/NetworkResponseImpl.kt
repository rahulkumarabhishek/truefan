package com.truefanproject.repositories.repositoryimpl

import com.truefanproject.api.apihelper.ApiHelper
import com.truefanproject.datamodels.QuizResponse
import com.truefanproject.repositories.repository.NetworkResponse
import retrofit2.Response

class NetworkResponseImpl(private val apiHelper: ApiHelper) : NetworkResponse {
    override suspend fun getQuizResponse(url: String): Response<List<QuizResponse>> {
        return apiHelper.getResponse(url)
    }
}