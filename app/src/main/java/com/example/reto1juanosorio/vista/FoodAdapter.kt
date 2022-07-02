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
import com.example.reto1juanosorio.controlador.MyOpenProductHelper
import com.google.android.material.button.MaterialButton
import de.hdodenhof.circleimageview.CircleImageView

class FoodAdapter(


    var nombrePlato : MutableList<String> = mutableListOf(),
    var precioPlato : MutableList<String> = mutableListOf(),
    var descriptionPlato : MutableList<String> = mutableListOf(),
    var listaImagenes : MutableList<Int> = mutableListOf(),
    var context : Context) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

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
        holder.textViewNombrePlato.text = nombrePlato.get(position)
        holder.textViewPrecioPlato.text = precioPlato.get(position)
        holder.imageList.setImageResource(listaImagenes.get(position))

        holder.botonComprar.setOnClickListener {

            var input : EditText = EditText(context)
            input.inputType = InputType.TYPE_CLASS_NUMBER
            
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Cantidad producto ${holder.textViewNombrePlato.text}")
                    .setMessage("¿Cuantas cantidades de este producto deseas agregar al carrito de compras?")
                    .setPositiveButton("Agregar", {dialogInteface: DialogInterface, i: Int ->}

                    )
                    .setNegativeButton("Cancelar", {dialogInteface: DialogInterface, i: Int ->})
            builder.setView(input)
            builder.create()
            builder.show()
        }

        holder.botonFavorito.setOnClickListener {

            var myOpenHelper : MyOpenProductHelper = MyOpenProductHelper(context)
            var db : SQLiteDatabase = myOpenHelper.readableDatabase
            var cursor : Cursor = myOpenHelper.select_by_id(""+position,db)
            var favorito : Int = 0
            while (cursor.moveToNext()){
                favorito = cursor.getInt(cursor.getColumnIndex(DBLocal.TB_PRODUCTO.FAVORITO))
            }
            if(favorito==0){
                //myOpenHelper.actualizarFavoritoProducto(1, Integer.parseInt(nombrePlato.get(position)), db)
                Toast.makeText(context,"Añadido a favoritos",Toast.LENGTH_SHORT)
            }
            else{
                //myOpenHelper.actualizarFavoritoProducto(0, Integer.parseInt(nombrePlato.get(position)), db)
                Toast.makeText(context,"Eliminado de favoritos",Toast.LENGTH_SHORT)
            }


        }

        if(mensajeToast.view!!.isShown){
            mensajeToast.cancel()
        }
        holder.cardView.setOnClickListener {
            mensajeToast.setText(descriptionPlato.get(position))
            mensajeToast.show()
        }
    }

    override fun getItemCount(): Int {
        return nombrePlato.size
    }


}