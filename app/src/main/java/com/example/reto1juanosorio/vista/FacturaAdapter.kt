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
import com.example.reto1juanosorio.modelo.ElementoFactura
import com.google.android.material.button.MaterialButton
import de.hdodenhof.circleimageview.CircleImageView

class FacturaAdapter(


    var elementosFactura : MutableList<ElementoFactura> = mutableListOf(),
    var context : Context) : RecyclerView.Adapter<FacturaAdapter.FacturaViewHolder>() {

    var mensajeToast : Toast =  Toast.makeText(context, "v", Toast.LENGTH_LONG)

    class FacturaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewNombrePlato : TextView = itemView.findViewById(R.id.nombrePlatoText)
        var textViewPrecioPlato : TextView = itemView.findViewById(R.id.precioPlatoView)
        var textViewCantidadPlato : TextView = itemView.findViewById(R.id.cantidadProductoTxt)
        var textViewPrecioTotalPlato : TextView = itemView.findViewById(R.id.totalPrecioProducto)
        var cardView : CardView = itemView.findViewById(R.id.cardFacturaView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacturaViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.factura_view, parent, false)
        return FacturaViewHolder(view)
    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: FacturaViewHolder, position: Int) {
        holder.textViewNombrePlato.text = elementosFactura.get(position).nombre_producto
        holder.textViewCantidadPlato.text = ""+elementosFactura.get(position).cantidad
        holder.textViewPrecioTotalPlato.text = ""+elementosFactura.get(position).total_precio
        holder.textViewPrecioPlato.text = ""+elementosFactura.get(position).precio

    }

    override fun getItemCount(): Int {
        return elementosFactura.size
    }


}