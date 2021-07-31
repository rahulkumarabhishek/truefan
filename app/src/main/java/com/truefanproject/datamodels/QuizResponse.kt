package com.truefanproject.datamodels

import com.google.gson.annotations.SerializedName

data class QuizResponse(@SerializedName("quizFound") val quizFound : Boolean,
                        @SerializedName("rank") val rank : Int,
                        @SerializedName("score") val score : Int,
                        @SerializedName("msg") val msg : String)

/*{
    "quizFound": true,
    "rank": 1,
    "score": 0,
    "msg": "With this score you could have won Personalized Video Message from celebrity by playing gold quiz"
}*/
