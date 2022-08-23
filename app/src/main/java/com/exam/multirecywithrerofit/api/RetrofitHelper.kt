package com.exam.multirecywithrerofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL="https://raw.githubusercontent.com/JobbyPradhan/testApi/main/"

    fun getInstance() : Retrofit {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofitBuilder
    }
}