package com.example.reto1juanosorio.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.reto1juanosorio.R

class StarterActivity : AppCompatActivity() {

    lateinit var vistaImagen : ImageView
    lateinit var restauranteNombre : TextView
    lateinit var  progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

        progressBar = findViewById(R.id.loading)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        progressBar.setProgress(0)

        try {
            vistaImagen = findViewById(R.id.restauranteLogoView)
            restauranteNombre = findViewById(R.id.nombreRestauranteText)
            progressBar.visibility = View.VISIBLE
            Handler().postDelayed({

                startActivity(Intent(this@StarterActivity, MainActivity::class.java))
                finish()
                progressBar.visibility = View.GONE
            }, 3000)

        }catch (excepcion:Exception){
            Log.e("Error : ", excepcion.toString())
        }
    }
}