package com.bandtec.atividadecontinuada2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CachoroEncontrado : AppCompatActivity() {
    lateinit var preferencias: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cachoro_encontrado)


        val txtCachorro: TextView = findViewById(R.id.txtCachorro1)
        val txtCachorro2: TextView = findViewById(R.id.txtCachorro2)

        preferencias = getSharedPreferences("authenticator", Context.MODE_PRIVATE)

        txtCachorro.text = preferencias.getString("cachorro1", "(Não encontrado)")
        txtCachorro2.text = preferencias.getString("cachorro2", "(Não encontrado)")

    }

    fun voltar(view: View) {
        onBackPressed()
    }


}