package com.truefanproject.datamodels

data class Quiz(
    val msg: String,
    val quizFound: Boolean,
    val rank: Int,
    val score: Int
)