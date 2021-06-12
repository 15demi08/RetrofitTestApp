package com.example.retrofittestapp.retrofit

import com.example.retrofittestapp.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CEPService {

    @GET("ws/{cep}/json")
    fun buscarCEP( @Path("cep") cep:String ):Call<Endereco>

}