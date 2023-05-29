package com.example.virtualmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtualmenu.databinding.ActivityAdminBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList

class AdminActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private lateinit var binding : ActivityAdminBinding

    private lateinit var adapterproduct : Adapterproductos
    private lateinit var producList : ArrayList<ItemProduct>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val guardarDatos = findViewById<Button>(R.id.buttonGuardar) as Button
        val borrarProducto = findViewById<Button>(R.id.buttonEliminar) as Button

        guardarDatos.setOnClickListener(){
            agregarDatos()
        }

        borrarProducto.setOnClickListener(){
            eliminarProducto()
            llamarrecyclerview()
        }

        llamarrecyclerview()
    }

    private fun llamarrecyclerview() {
        producList = ArrayList()
        adapterproduct = Adapterproductos(producList)
        db.collection("Productos")
            .get()
            .addOnSuccessListener { documets ->
                for(document in documets){
                    val wallItem = document.toObject(ItemProduct::class.java)
                    wallItem.idProduct = document.id
                    wallItem.nomProduct = document["Nombre"].toString()
                    wallItem.tipProduct = document["Tipo"].toString()
                    wallItem.preProduct = document["Precio"].toString().toInt()
                    wallItem.nitProduct = document["Codigo"].toString()
                    wallItem.imgProduct = document["Imagen"].toString()

                    binding.recyclerssProduct.adapter = adapterproduct
                    binding.recyclerssProduct.layoutManager = LinearLayoutManager(this)
                    producList.add(wallItem)
                }
            }

    }

    private fun agregarDatos() {

        if(binding.DatoTipo.text.toString().isBlank() or binding.DatoPrecio.text.toString().isBlank() or binding.DatoNitProducto.text.toString().isBlank()) {
            Toast.makeText(this, "Por favor rellene los campos", Toast.LENGTH_LONG).show()
        }

        else{
            val user = hashMapOf(

                "Nombre" to binding.DatoProducto.text.toString(),
                "Tipo" to binding.DatoTipo.text.toString(),
                "Precio" to binding.DatoPrecio.text.toString().toInt(),
                "Codigo" to binding.DatoNitProducto.text.toString(),
                "Imagen" to "https://waifus.wiki/wp-content/uploads/2021/07/Es2oz-LW4AEqdmd.jpg"

            )
            db.collection("Productos")
                .add(user)
                .addOnSuccessListener {  documentReference ->
                    Toast.makeText(this, "Producto agregado correctamente", Toast.LENGTH_LONG).show()
                    println("agregado correctamente")


                    llamarrecyclerview()
                    adapterproduct.notifyDataSetChanged()
                }
                .addOnFailureListener {e-> Log.w("Tag","Error $e")}


            binding.DatoProducto.text.clear()
            binding.DatoTipo.text.clear()
            binding.DatoPrecio.text.clear()
            binding.DatoNitProducto.text.clear()

        }
    }
    private fun eliminarProducto() {

        val datoBuscar =binding.DatoBuscarProducto.text.toString()
        //val docRef = db.collection("Productos").document( binding.DatoBuscarProducto.text.toString()).toString()

        if(binding.DatoBuscarProducto.text.toString().isBlank() ){
            Toast.makeText(this, "No puso el Codigo de producto", Toast.LENGTH_LONG).show()
        }
        else{

            db.collection("Productos").document( binding.DatoBuscarProducto.text.toString())
                .delete()
                .addOnSuccessListener { Log.d("Tag","se Elimino correctamente $datoBuscar") }
                .addOnFailureListener {e-> Log.w("Tag","Error al borrar el documento $e")}

            Toast.makeText(this, "Se elimino correctamente $datoBuscar", Toast.LENGTH_LONG).show()
            binding.DatoBuscarProducto.text.clear()

            //llamarrecyclerview()
            //adapterproduct.notifyDataSetChanged()

        }
    }
}