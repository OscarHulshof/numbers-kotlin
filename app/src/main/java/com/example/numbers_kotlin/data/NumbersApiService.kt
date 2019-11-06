package com.example.numbers_kotlin.data

import com.example.numbers_kotlin.model.Trivia
import retrofit2.Call
import retrofit2.http.GET

interface NumbersApiService {
    @GET("/random/trivia?json")
    fun getRandomNumberTrivia(): Call<Trivia>
}