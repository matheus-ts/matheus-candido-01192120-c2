package com.bandtec.atividadecontinuada2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CachorroNotFound : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cachorro_not_found)
    }

    fun voltar(view: View) {
        onBackPressed()
    }
}