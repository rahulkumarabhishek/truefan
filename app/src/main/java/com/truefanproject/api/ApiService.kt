package com.truefanproject.api

import com.truefanproject.datamodels.QuizResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getQuizResponse(@Url url:String): Response<List<QuizResponse>>
}