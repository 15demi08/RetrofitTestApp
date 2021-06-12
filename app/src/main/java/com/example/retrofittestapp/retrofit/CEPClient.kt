package com.example.retrofittestapp.retrofit

import android.util.Log
import com.example.retrofittestapp.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CEPClient( val appRetrofit:CEPService? = AppRetrofit().service ) {

    fun buscarCEP(
        cep:String,
        onSuccess: (endereco:Endereco?) -> Unit,
        onFailure: (msg:String?) -> Unit
    ){
        appRetrofit?.buscarCEP(cep)?.enqueue(object: Callback<Endereco> {
            override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                if(response.isSuccessful)
                    onSuccess(response.body())
                else
                    onFailure("Erro não identificado!")
            }

            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                onFailure(t.message)
                Log.i("API", t.message.toString())
            }

        })
    }

}