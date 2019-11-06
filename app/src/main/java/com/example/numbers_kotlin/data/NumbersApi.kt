package com.example.numbers_kotlin.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NumbersApi {
    companion object {
        private const val baseUrl = "http://numbersapi.com/"

        fun createApi(): NumbersApiService {
            // Create HTTP client to log network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Create Retrofit instance
            val numbersApi = Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()

            // Return Retrofit NumbersApiService
            return numbersApi.create(NumbersApiService::class.java)
        }
    }
}