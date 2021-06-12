package com.example.retrofittestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.retrofittestapp.model.Endereco
import com.example.retrofittestapp.retrofit.CEPClient

class MainActivity : AppCompatActivity() {

    val cepClient: CEPClient by lazy {
        CEPClient()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnBuscarCEP).setOnClickListener(this::consultarCEP)

    }

    fun consultarCEP( v:View ){

        findViewById<TextView>(R.id.lblFoundData).visibility = TextView.INVISIBLE
        findViewById<TextView>(R.id.txtAddress).visibility = TextView.INVISIBLE

        cepClient.buscarCEP(

            findViewById<EditText>(R.id.txteCEP).text.toString(),
            onSuccess = { endereco ->
                findViewById<TextView>(R.id.lblFoundData).visibility = TextView.VISIBLE
                findViewById<TextView>(R.id.txtAddress).text = construirStringResultado(endereco)
                findViewById<TextView>(R.id.txtAddress).visibility = TextView.VISIBLE
            },
            onFailure = {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }

        )

    }

    private fun construirStringResultado(e:Endereco?): String {

        return "CEP: ${e?.cep}\n" +
                "UF: ${e?.uf}\n" +
                "Localidade: ${e?.localidade}\n" +
                "Logradouro: ${e?.logradouro}\n" +
                "Complemento: ${e?.complemento}\n" +
                "Bairro: ${e?.bairro}\n" +
                "IBGE: ${e?.ibge}\n" +
                "GIA: ${e?.gia}\n" +
                "DDD: ${e?.ddd}\n" +
                "SIAFI: ${e?.siafi}"

    }

}