package com.example.retrofittestapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppRetrofit {

    val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val service by lazy {
        retrofit.create(CEPService::class.java)
    }

}