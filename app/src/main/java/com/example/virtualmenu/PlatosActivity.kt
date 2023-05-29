package com.example.virtualmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PlatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platos)

        val BtnSopa = findViewById<ImageButton>(R.id.imgBtnSopa) as ImageButton
        val BtnSegundo = findViewById<ImageButton>(R.id.imgBtnSegundo) as ImageButton
        val BtnExtra = findViewById<ImageButton>(R.id.imgBtnExtra) as ImageButton

        BtnSopa.setOnClickListener(){
            val intent = Intent(this , SopasActivity::class.java)
            startActivity(intent)
        }
        BtnSegundo.setOnClickListener(){
            val intent = Intent(this , SegundosActivity::class.java)
            startActivity(intent)
        }
        BtnExtra.setOnClickListener(){
            val intent = Intent(this , ExtrasActivity::class.java)
            startActivity(intent)
        }

    }



}