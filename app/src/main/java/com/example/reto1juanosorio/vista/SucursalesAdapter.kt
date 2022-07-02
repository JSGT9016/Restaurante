package com.example.reto1juanosorio.vista

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


import com.example.reto1juanosorio.R
import com.example.reto1juanosorio.vista.locations.*
import java.lang.StringBuilder


class SucursalesAdapter(
    var nombreSucursal : MutableList<String> = mutableListOf(),
    var direccionSucursal : MutableList<String> = mutableListOf(),
    var ubicacionMapa : MutableList<String> = mutableListOf(),
    var context : Context) : RecyclerView.Adapter<SucursalesAdapter.SucursalesViewHolder>() {


        class SucursalesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var textViewNombreSucursal : TextView = itemView.findViewById(R.id.nombreSucursalText)
            var textViewDireccionSucursal : TextView = itemView.findViewById(R.id.direccionSucursalText)
            var cardView : CardView = itemView.findViewById(R.id.cardFacturaView)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SucursalesViewHolder {
            val view : View = LayoutInflater.from(parent.context).inflate(R.layout.sucursales_view, parent, false)
            return SucursalesViewHolder(view)
        }

        override fun onBindViewHolder(holder: SucursalesViewHolder, position: Int) {
            holder.textViewNombreSucursal.text = nombreSucursal.get(position)
            holder.textViewDireccionSucursal.text = direccionSucursal.get(position)

            holder.cardView.setOnClickListener {
                /*
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(ubicacionMapa.get(position)))
                context.startActivity(browserIntent)
                */
                if(nombreSucursal.get(position).equals("Sucursal Santa Fe")){
                    val browserIntent = Intent(context, SantaFeActivity::class.java)
                    context.startActivity(browserIntent)
                }
                if(nombreSucursal.get(position).equals("Sucursal Unicentro")){
                    val browserIntent = Intent(context, UnicentroActivity::class.java)
                    context.startActivity(browserIntent)
                }
                if(nombreSucursal.get(position).equals("Sucursal Palatino")){
                    val browserIntent = Intent(context, PalatinoActivity::class.java)
                    context.startActivity(browserIntent)
                }
                if(nombreSucursal.get(position).equals("Sucursal Portal 80")){
                    val browserIntent = Intent(context,
                        Portal80Activity::class.java)
                    context.startActivity(browserIntent)
                }
                if(nombreSucursal.get(position).equals("Sucursal Titan Plaza")){
                    val browserIntent = Intent(context, TitanPlazaActivity::class.java)
                    context.startActivity(browserIntent)
                }



            }
        }

        override fun getItemCount(): Int {
            return nombreSucursal.size
        }

}