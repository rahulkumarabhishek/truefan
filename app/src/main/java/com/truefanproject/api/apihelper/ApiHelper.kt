package com.truefanproject.api.apihelper

import com.truefanproject.api.ApiService

class ApiHelper(private val apiService: ApiService) {
    suspend fun getResponse(url:String) = apiService.getQuizResponse(url)
}