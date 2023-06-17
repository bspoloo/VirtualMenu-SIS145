package com.example.virtualmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtualmenu.databinding.ActivityCervezasBinding
import com.example.virtualmenu.databinding.ActivitySopasBinding
import com.google.firebase.firestore.FirebaseFirestore

class CervezasActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private lateinit var binding : ActivityCervezasBinding

    private lateinit var adapterproduct : AdapterMuestraProductos
    private lateinit var producList : ArrayList<ItemProduct>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCervezasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llamarrecyclerview()
    }

    private fun llamarrecyclerview() {
        producList = java.util.ArrayList()
        adapterproduct = AdapterMuestraProductos(producList)
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


                    binding.recyclerssProductCervezas.adapter = adapterproduct
                    binding.recyclerssProductCervezas.layoutManager = LinearLayoutManager(this)
                    producList.add(wallItem)
                }
            }

    }


}