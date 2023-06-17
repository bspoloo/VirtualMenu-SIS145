package com.example.virtualmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtualmenu.databinding.ActivitySegundosBinding
import com.example.virtualmenu.databinding.ActivitySopasBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList

class SegundosActivity : AppCompatActivity() {


    val db = FirebaseFirestore.getInstance()
    private lateinit var binding : ActivitySegundosBinding

    private lateinit var adapterprodct : AdapterMuestraProductos
    private lateinit var producList : ArrayList<ItemProduct>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llamarrecyclerview()
    }
    private fun llamarrecyclerview() {
        producList = ArrayList()


        adapterprodct = AdapterMuestraProductos(producList)
        db.collection("Productos")
            .whereEqualTo("Tipo", "Segundos")
            .get()
            .addOnSuccessListener { documets ->
                for (document in documets) {
                    val wallItem = document.toObject(ItemProduct::class.java)
                    wallItem.id = document.id
                    wallItem.nom = document["Nombre"].toString()
                    wallItem.tip = document["Tipo"].toString()
                    wallItem.descp = document["Descripcion"].toString()
                    wallItem.pre = document["Precio"].toString().toInt()

                    wallItem.imgProduct = document["Imagen"].toString()

                    binding.recyclerssProductSegundos.adapter = adapterprodct
                    binding.recyclerssProductSegundos.layoutManager = LinearLayoutManager(this)
                    producList.add(wallItem)

                }
            }
    }
}