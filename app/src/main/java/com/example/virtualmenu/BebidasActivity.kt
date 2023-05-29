package com.example.virtualmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class BebidasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bebidas)

        val BtnGaseosa = findViewById<ImageButton>(R.id.imgBtnGaseosa) as ImageButton
        val BtnRefresco = findViewById<ImageButton>(R.id.imgBtnRefresco) as ImageButton
        val BtnCerveza = findViewById<ImageButton>(R.id.imgBtnCerveza) as ImageButton
        val BtnTe = findViewById<ImageButton>(R.id.imgBtnTe) as ImageButton

        BtnGaseosa.setOnClickListener(){
            val intent = Intent(this , GaseosasActivity::class.java)
            startActivity(intent)
        }
        BtnRefresco.setOnClickListener(){
            val intent = Intent(this , RefrescosActivity::class.java)
            startActivity(intent)
        }
        BtnCerveza.setOnClickListener(){
            val intent = Intent(this , CervezasActivity::class.java)
            startActivity(intent)
        }
        BtnTe.setOnClickListener(){
            val intent = Intent(this , TesActivity::class.java)
            startActivity(intent)
        }
    }

}