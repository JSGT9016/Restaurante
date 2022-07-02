package com.example.reto1juanosorio.vista

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto1juanosorio.R
import com.example.reto1juanosorio.controlador.DBLocal
import com.example.reto1juanosorio.controlador.MyOpenProductHelper
import com.example.reto1juanosorio.modelo.Producto

class PostreActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    private var listaPostres : MutableList<Producto> = mutableListOf()
    private var listaPlatos : MutableList<Producto> = mutableListOf()

    lateinit var adaptador : FoodAdapterV2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postre)

        var actionBar: ActionBar = supportActionBar!!


        actionBar.title = Html.fromHtml("<font color='#FFFFFF'>Postres </font>")
        actionBar.subtitle = Html.fromHtml("<font color='#FFFFFF'>Aqui nuestro menu de dulces </font>")
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        var color: ColorDrawable = ColorDrawable(Color.parseColor("#000000"))
        actionBar.setBackgroundDrawable(color)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@PostreActivity)

        listaPlatos = consultaPostres(this@PostreActivity)

        for(producto in listaPlatos){
            if(producto.categoria.equals("Postre")){
                listaPostres.add(producto)
            }
        }


        adaptador = FoodAdapterV2(listaPostres, this@PostreActivity)
        recyclerView.adapter = adaptador
    }

    fun consultaPostres(context: Context): MutableList<Producto>{

        var listadoPostres : MutableList<Producto> = mutableListOf()
        var myOpenHelper : MyOpenProductHelper = MyOpenProductHelper(context)
        var db : SQLiteDatabase = myOpenHelper.readableDatabase
        var cursor : Cursor = myOpenHelper.leerProductos(db)

        while (cursor.moveToNext()){
            @SuppressLint("Range")  var id : String = cursor.getString(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.ID))
            @SuppressLint("Range")  var nombre : String = cursor.getString(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.NOMBRE))
            @SuppressLint("Range")  var descripcion : String = cursor.getString(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.DESCRIPCION))
            @SuppressLint("Range")  var precio : Int = cursor.getInt(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.PRECIO))
            @SuppressLint("Range")  var imagen : Int = cursor.getInt(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.IMAGEN))
            @SuppressLint("Range")  var categoria : String = cursor.getString(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.CATEGORIA))
            listadoPostres.add(
                Producto(
                    id,
                    nombre,
                    descripcion,
                    "" + precio,
                    imagen,
                    categoria
                )
            )
        }


        return listadoPostres
    }

}