package com.example.reto1juanosorio.vista

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.ActionBar
import com.example.reto1juanosorio.R

class ContactanosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactanos)

        var actionBar : ActionBar = supportActionBar!!
        var color : ColorDrawable = ColorDrawable(Color.parseColor("#000000"))
        actionBar.setBackgroundDrawable(color)
        actionBar.title = Html.fromHtml("<font color='#FFFFFF'>Contactanos </font>")
        actionBar.subtitle = Html.fromHtml("<font color='#FFFFFF'>Cuentanos que piensas</font>")


    }
}