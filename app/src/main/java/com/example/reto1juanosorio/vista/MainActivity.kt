package com.example.reto1juanosorio.vista

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto1juanosorio.R
import com.example.reto1juanosorio.controlador.DBLocal
import com.example.reto1juanosorio.controlador.MyOpenProductHelper
import com.example.reto1juanosorio.modelo.Producto

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    private var listaProductos : MutableList<Producto> = mutableListOf()
    private var listaPlatos : MutableList<Producto> = mutableListOf()


    lateinit var adaptador : FoodAdapterV2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var actionBar: ActionBar = supportActionBar!!

        actionBar.title = Html.fromHtml("<font color='#FFFFFF'>Restaurante </font>")
        actionBar.subtitle = Html.fromHtml("<font color='#FFFFFF'>La Comilona </font>")
        actionBar.setIcon(R.mipmap.restaurant_icon)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        var color: ColorDrawable = ColorDrawable(Color.parseColor("#000000"))
        actionBar.setBackgroundDrawable(color)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        //listaProductos = PlatosPrincipales.listadoProductos()
        listaProductos = consultarPlatos(this@MainActivity)

        for(producto in listaProductos){
            if(producto.categoria.equals("Plato principal")){
                listaPlatos.add(producto)
            }
        }

        adaptador = FoodAdapterV2(listaPlatos, this@MainActivity)
        recyclerView.adapter = adaptador

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_app_restaurante, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.platos -> {
                Toast.makeText(this, "Estas en esa pagina en estos momentos", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.favoritos -> {
                startActivity(Intent(this@MainActivity, FavoritosActivity::class.java))
                return true
            }
            R.id.postres -> {
                startActivity(Intent(this@MainActivity, PostreActivity::class.java))
                return true
            }
            R.id.contactanos -> {
                startActivity(Intent(this@MainActivity, ContactanosActivity::class.java))
                return true
            }
            R.id.sucursales ->{
                startActivity(Intent(this@MainActivity, SucursalesActivity::class.java))
                return true
            }
            R.id.carrito_compras -> {
                startActivity(Intent(this@MainActivity, FacturaActivity::class.java))
                return true
            }


            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun consultarPlatos(context: Context): MutableList<Producto>{

        var listadoPlatos : MutableList<Producto> = mutableListOf()
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
            listadoPlatos.add(
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

        return listadoPlatos
    }
}