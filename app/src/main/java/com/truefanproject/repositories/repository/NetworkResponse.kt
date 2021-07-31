package com.truefanproject.repositories.repository

import com.truefanproject.datamodels.QuizResponse
import retrofit2.Response

interface NetworkResponse {
     suspend fun  getQuizResponse(url:String):Response<List<QuizResponse>>
}