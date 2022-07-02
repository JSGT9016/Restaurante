package com.example.reto1juanosorio.vista

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto1juanosorio.R
import com.example.reto1juanosorio.controlador.DBLocal
import com.example.reto1juanosorio.controlador.MyElementoFacturaOpenHelper
import com.example.reto1juanosorio.controlador.MyOpenProductHelper
import com.example.reto1juanosorio.modelo.ElementoFactura
import com.example.reto1juanosorio.modelo.Producto

class FacturaActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var cancelarButton : Button
    lateinit var comprarButton : Button

    private var listaElementosFactura : MutableList<ElementoFactura> = mutableListOf()

    private lateinit var adaptador : FacturaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        var actionBar: ActionBar = supportActionBar!!


        actionBar.title = Html.fromHtml("<font color='#FFFFFF'>Carrito de compras</font>")
        actionBar.subtitle = Html.fromHtml("<font color='#FFFFFF'>Tus productos hasta ahora seleccionados..</font>")
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        var color: ColorDrawable = ColorDrawable(Color.parseColor("#000000"))
        actionBar.setBackgroundDrawable(color)

        recyclerView = findViewById(R.id.listadoProductosComprados)
        cancelarButton = findViewById(R.id.cancelarBtn)
        comprarButton = findViewById(R.id.comprarBtn)

        recyclerView.layoutManager = LinearLayoutManager(this@FacturaActivity)

        listaElementosFactura = consultaElementosFactura(this@FacturaActivity)

        var context : Context = this@FacturaActivity

       cancelarButton.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("¿Cancelar Pedido?")
                .setMessage("¿Estas seguro de cancelar el pedido?")
                .setPositiveButton("Si" ,
                ) { dialogInteface: DialogInterface, i: Int ->
                    var myOpenHelper: MyElementoFacturaOpenHelper = MyElementoFacturaOpenHelper(context)
                    var db: SQLiteDatabase = myOpenHelper.readableDatabase
                    myOpenHelper.delete_all_elementos_factura(db)
                    Toast.makeText(context, "Pedido cancelado!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No!", { dialogInteface: DialogInterface, i: Int -> Toast.makeText(context, "Todo bien!", Toast.LENGTH_SHORT).show()})
            builder.create()
            builder.show()

        }

        comprarButton.setOnClickListener {
            Toast.makeText(context, "Aun falta por desarrollar dicha funcionalidad...", Toast.LENGTH_SHORT)
        }

        adaptador = FacturaAdapter( listaElementosFactura, this@FacturaActivity)
        recyclerView.adapter = adaptador
    }

    fun consultaElementosFactura(context: Context): MutableList<ElementoFactura>{

        var listadoElementosFactura : MutableList<ElementoFactura> = mutableListOf()
        var myOpenHelper : MyElementoFacturaOpenHelper = MyElementoFacturaOpenHelper(context)
        var db : SQLiteDatabase = myOpenHelper.readableDatabase
        var cursor : Cursor = myOpenHelper.select_all_elementos_factura(db)

        while (cursor.moveToNext()){
            @SuppressLint("Range")  var nombre : String = cursor.getString(cursor.getColumnIndex(DBLocal.TB_ELEMENTO_FACTURA.NOMBRE_PRODUCTO))
            @SuppressLint("Range")  var precio : Int = cursor.getInt(cursor.getColumnIndex(DBLocal.TB_ELEMENTO_FACTURA.PRECIO))
            @SuppressLint("Range")  var cantidad : Int = cursor.getInt(cursor.getColumnIndex(DBLocal.TB_ELEMENTO_FACTURA.CANTIDAD))
            @SuppressLint("Range")  var precio_total : Int = precio*cantidad
            @SuppressLint("Range")  var imagen : Int = cursor.getInt(cursor.getColumnIndex(DBLocal.TB_ELEMENTO_FACTURA.IMAGEN))

            listadoElementosFactura.add(
                ElementoFactura(
                    nombre,
                    precio,
                    cantidad,
                    imagen
                )
            )
        }

        return listadoElementosFactura
    }
}