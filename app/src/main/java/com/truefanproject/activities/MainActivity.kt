package com.truefanproject.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.truefanproject.R
import com.truefanproject.viewmodels.MainActivityViewMdel

class MainActivity : AppCompatActivity() {
    private lateinit var model: MainActivityViewMdel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProvider(this)[MainActivityViewMdel::class.java]

    }

    override fun onResume() {
        super.onResume()
        model.getQuiz()
        model.quizList.observe(this,{
            Log.d("MainActivity",it.toString())
        })
        model.errorMessage.observe(this,{
            Log.d("MainActivity",it.toString())
        })
    }
}