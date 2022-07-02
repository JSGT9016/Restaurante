package com.example.reto1juanosorio.vista

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.reto1juanosorio.R
import com.example.reto1juanosorio.controlador.DBLocal
import com.example.reto1juanosorio.controlador.MyElementoFacturaOpenHelper
import com.example.reto1juanosorio.controlador.MyOpenProductHelper
import com.example.reto1juanosorio.modelo.ElementoFactura
import com.example.reto1juanosorio.modelo.Producto
import com.google.android.material.button.MaterialButton
import de.hdodenhof.circleimageview.CircleImageView

class FoodAdapterV2(


    var productos : MutableList<Producto> = mutableListOf(),
    var context : Context) : RecyclerView.Adapter<FoodAdapterV2.FoodViewHolder>() {

    var mensajeToast : Toast =  Toast.makeText(context, "v", Toast.LENGTH_LONG)

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewNombrePlato : TextView = itemView.findViewById(R.id.nombrePlatoText)
        var textViewPrecioPlato : TextView = itemView.findViewById(R.id.precioPlatoView)
        var imageList : CircleImageView = itemView.findViewById(R.id.imageView)
        var cardView : CardView = itemView.findViewById(R.id.cardFacturaView)
        var botonComprar :Button = itemView.findViewById(R.id.btnComprar)
        var botonFavorito : MaterialButton = itemView.findViewById(R.id.btnFavorito)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.producto_view_v2, parent, false)
        return FoodViewHolder(view)
    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.textViewNombrePlato.text = productos.get(position).nombre
        holder.textViewPrecioPlato.text = productos.get(position).precio
        holder.imageList.setImageResource(productos.get(position).imagen)

        holder.botonComprar.setOnClickListener {

            var input : EditText = EditText(context)
            input.inputType = InputType.TYPE_CLASS_NUMBER

            val builder = AlertDialog.Builder(context)
            builder.setView(input)
            builder.setTitle("Cantidad producto ${holder.textViewNombrePlato.text}")
                .setMessage("¿Cuantas cantidades de este producto deseas agregar al carrito de compras?")
                .setPositiveButton("Agregar al carrito" ,
                ) { dialogInteface: DialogInterface, i: Int ->
                    if(Integer.parseInt(input.text.toString())>0) {
                        var myOpenHelper: MyElementoFacturaOpenHelper =
                            MyElementoFacturaOpenHelper(context)
                        var db: SQLiteDatabase = myOpenHelper.readableDatabase
                        myOpenHelper.insertarElementoFactura(
                            ElementoFactura(
                                productos.get(position).nombre,
                                Integer.parseInt(productos.get(position).precio),
                                Integer.parseInt(input.text.toString()),
                                productos.get(position).imagen
                            ), db
                        )
                        Toast.makeText(context, "Producto agregado al carrito!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    else{
                        Toast.makeText(context, "No se pudo agregar, La cantidad minima para agregar al carrito es de 1", Toast.LENGTH_LONG).show()
                    }
                }
                .setNegativeButton("Cancelar", {dialogInteface: DialogInterface, i: Int -> Toast.makeText(context, "Cancelada seleccion! ${input.text}", Toast.LENGTH_SHORT).show()})
            builder.setView(input)
            builder.create()
            builder.show()
        }

        holder.botonFavorito.setOnClickListener {

            var myOpenHelper : MyOpenProductHelper = MyOpenProductHelper(context)
            var db : SQLiteDatabase = myOpenHelper.readableDatabase
            var cursor : Cursor = myOpenHelper.select_by_id(productos.get(position).id,db)
            var favorito : Int = 0
            while (cursor.moveToNext()){
                favorito = cursor.getInt(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.FAVORITO))
            }
            if(favorito==0){
                myOpenHelper.actualizarFavoritoProducto(1, productos.get(position).id, db)
                Toast.makeText(context,"Añadido a favoritos ${productos.get(position).nombre}",Toast.LENGTH_SHORT).show()
            }
            else{
                myOpenHelper.actualizarFavoritoProducto(0, productos.get(position).id, db)
                Toast.makeText(context,"Eliminado de favoritos ${productos.get(position).nombre}",Toast.LENGTH_SHORT).show()
            }


        }

    }

    override fun getItemCount(): Int {
        return productos.size
    }


}