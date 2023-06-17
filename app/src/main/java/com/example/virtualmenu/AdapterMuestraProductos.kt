package com.example.virtualmenu

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore


class AdapterMuestraProductos(private var items: MutableList<ItemProduct>):
    RecyclerView.Adapter<AdapterMuestraProductos.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): AdapterMuestraProductos.ViewHolder {
        return AdapterMuestraProductos.ViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.itemmuestraprod,parent,false)

        )
    }

    override fun onBindViewHolder(holder: AdapterMuestraProductos.ViewHolder, position: Int) {
        val item = items[position]


        holder.nomP.text = item.nom
        holder.tipP.text = item.tip
        holder.descpP.text = item.descp
        holder.preP.text = item.pre.toString()

        Glide.with(holder.itemView.context).load(item.imgProduct).circleCrop().into(holder.fotP)

        holder.botnPD.setOnClickListener{
            val activity = it.context //as AppCompatActivity
            Toast.makeText(activity,"ollo, soy ${item.nom} ${item.tip}", Toast.LENGTH_LONG).show()
            println("ollo, soy ${item.nom} ${item.tip}")

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nomP: TextView = view.findViewById(R.id.nombreProducto)
        val tipP: TextView = view.findViewById(R.id.tipoProducto)
        val descpP: TextView = view.findViewById(R.id.descpProducto)
        val preP: TextView = view.findViewById(R.id.precioProducto)
        val fotP: ImageView = view.findViewById(R.id.fotoProducto)
        //para los botones creados en itemproduct

        val botnPD: Button = view.findViewById(R.id.botonDetalles)


    }

}