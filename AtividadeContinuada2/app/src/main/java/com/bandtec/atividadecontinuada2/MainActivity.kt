package com.bandtec.atividadecontinuada2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import retrofit2.Callback
import android.widget.EditText
import android.widget.Toast
import com.bandtec.atividadecontinuada2.conexaoApiCachorros.Cachorro
import com.bandtec.atividadecontinuada2.conexaoApiCachorros.ConexaoCachorroApi
import retrofit2.Call
import retrofit2.Response
import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {
    lateinit var preferencias:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencias = getSharedPreferences("authenticator", Context.MODE_PRIVATE)

    }

    fun proximaTela() {
        startActivity(Intent(this, CachoroEncontrado::class.java))
    }

    fun naoEncontrado() {
        startActivity(Intent(this, CachorroNotFound::class.java))
    }

    fun proximaTela(view: View) {
        val apiCachorros = ConexaoCachorroApi.criar()
        val etId1: EditText = findViewById(R.id.et_identificador1)
        val etId2: EditText = findViewById(R.id.et_identificador2)

        val identificador1 = etId1.text.toString().toInt();
        val identificador2 = etId2.text.toString().toInt();

        apiCachorros.get(identificador1).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                val cachorro = response.body()
                if (cachorro != null) {

                    val edit = preferencias.edit()

                    edit.putString("id1",cachorro.id)
                    edit.putString("cachorro1", cachorro.raca)
                    nextSearch()
                } else {
                    nextSearch()
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
            }
        }
        )
    }

    fun nextSearch(){
        val apiCachorros = ConexaoCachorroApi.criar()
        val etId1: EditText = findViewById(R.id.et_identificador1)
        val etId2: EditText = findViewById(R.id.et_identificador2)

        val identificador1 = etId1.text.toString().toInt();
        val identificador2 = etId2.text.toString().toInt();

        apiCachorros.get(identificador2).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                val cachorro = response.body()
                if (cachorro != null) {
                    val edit = preferencias.edit()


                    edit.putString("id2",cachorro.id)
                    edit.putString("cachorro2", cachorro.raca)

                    proximaTela()
                } else {
                    println(cachorro)
                    naoEncontrado()
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
            }
        }
        )
    }
}