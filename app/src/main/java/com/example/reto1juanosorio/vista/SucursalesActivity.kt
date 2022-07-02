package com.example.reto1juanosorio.vista

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto1juanosorio.R
import com.example.reto1juanosorio.datos.ListadoSucursales
import com.example.reto1juanosorio.modelo.Sucursal

class SucursalesActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    private var nombreSucursal : MutableList<String> = mutableListOf()
    private var direccionSucursal : MutableList<String> = mutableListOf()
    private var ubicacionMapaSucursal : MutableList<String> = mutableListOf()

    private var listaSucursales : MutableList<Sucursal> = mutableListOf()

    lateinit var adaptador : SucursalesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucursales)

        var actionBar : ActionBar = supportActionBar!!

        actionBar.title = Html.fromHtml("<font color='#FF5722'>Sucursales </font>")
        actionBar.subtitle = Html.fromHtml("<font color='#FF5722'>Toca en cada sucursal para ver en mapa.</font>")
        actionBar.setDisplayShowHomeEnabled(true)
        var color : ColorDrawable = ColorDrawable(Color.parseColor("#000000"))
        actionBar.setBackgroundDrawable(color)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@SucursalesActivity)

        listaSucursales = ListadoSucursales.listadoSucursales()

        for(sucursal in listaSucursales){
            nombreSucursal.add(sucursal.nombre)
            direccionSucursal.add(sucursal.direccion)
            ubicacionMapaSucursal.add(sucursal.ubicacionMapa)
        }

        adaptador = SucursalesAdapter(nombreSucursal, direccionSucursal, ubicacionMapaSucursal, this@SucursalesActivity)
        recyclerView.adapter = adaptador

    }
}