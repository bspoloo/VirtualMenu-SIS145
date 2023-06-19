
package com.example.virtualmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtualmenu.databinding.ActivityAdminBinding
import com.example.virtualmenu.databinding.ActivityCervezasBinding
import com.example.virtualmenu.databinding.ActivityTodoslosProductosBinding
import com.google.firebase.firestore.FirebaseFirestore

class TodoslosProductos_Activity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    private lateinit var adapterprodct : Adapterproductos
    private lateinit var producList : java.util.ArrayList<ItemProduct>
    private lateinit var binding : ActivityTodoslosProductosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoslosProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)



            llamarrecyclerview()
        }

    private fun llamarrecyclerview() {
        producList = ArrayList()

        adapterprodct = Adapterproductos(producList)

        db.collection("Productos")
            .get()
            .addOnSuccessListener { documets ->
                for(document in documets){
                    val wallItem = document.toObject(ItemProduct::class.java)

                    wallItem.id = document.id
                    wallItem.nom = document["Nombre"].toString()
                    wallItem.tip = document["Tipo"].toString()
                    wallItem.descp = document["Descripcion"].toString()
                    wallItem.pre = document["Precio"].toString().toInt()
                    wallItem.imgProduct = document["Imagen"].toString()

                    binding.recyclerstodoslosproductos.adapter = adapterprodct
                    binding.recyclerstodoslosproductos.layoutManager = LinearLayoutManager(this)
                    producList.add(wallItem)
                }
            }

    }


}

