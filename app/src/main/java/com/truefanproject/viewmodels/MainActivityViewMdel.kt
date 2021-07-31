package com.truefanproject.viewmodels

import androidx.lifecycle.*
import com.truefanproject.api.APIClient
import com.truefanproject.api.apihelper.ApiHelper
import com.truefanproject.datamodels.QuizResponse
import com.truefanproject.myenum.Status
import com.truefanproject.repositories.repository.NetworkResponse
import com.truefanproject.repositories.repositoryimpl.NetworkResponseImpl
import kotlinx.coroutines.*

class MainActivityViewMdel : ViewModel() {
    private var networkResponse: NetworkResponse
    val errorMessage = MutableLiveData<String>()
    val quizList = MutableLiveData<List<QuizResponse>>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    init {
        val apihelper = ApiHelper(APIClient.apiService)
        networkResponse = NetworkResponseImpl(apihelper)

    }

    private fun onError(error: String) {
        errorMessage.postValue(error)
    }

    fun getQuiz() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            Status.LOADING
            val res = networkResponse.getQuizResponse("https://www.mocky.io/v2/5ec3eca9300000bed639c56e")
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    quizList.postValue(res.body())
                } else {
                    onError("Error : ${res.message()} ")
                }
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}