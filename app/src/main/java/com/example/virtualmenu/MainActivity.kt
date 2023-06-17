package com.example.virtualmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //agregamos un analitycs para prueba rapida:

        val analitycs = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","comenzando app")

        analitycs.logEvent("MainActivity", bundle)

        val ButtonSopa = findViewById<ImageButton>(R.id.imgBtnSopa) as ImageButton
        val ButtonSegundo = findViewById<ImageButton>(R.id.imgBtnSegundo) as ImageButton
        val ButtonExtras = findViewById<ImageButton>(R.id.imgBtnExtra) as ImageButton
        val ButtonGaseosa = findViewById<ImageButton>(R.id.imgBtnGaseosa) as ImageButton
        val ButtonRefresco = findViewById<ImageButton>(R.id.imgBtnRefresco) as ImageButton
        val ButtonCerveza = findViewById<ImageButton>(R.id.imgBtnCerveza) as ImageButton
        val ButtonPostres = findViewById<ImageButton>(R.id.buttonPostres) as ImageButton
        val ButtonAcerca = findViewById<ImageButton>(R.id.buttonAcerca) as ImageButton
        val ButtonAdmin = findViewById<FloatingActionButton>(R.id.adminbtn) as FloatingActionButton

        ButtonSopa.setOnClickListener(){
            val intent = Intent(this , SopasActivity::class.java)
            startActivity(intent)
        }
        ButtonSegundo.setOnClickListener(){
            val intent = Intent(this , SegundosActivity::class.java)
            startActivity(intent)
        }
        ButtonExtras.setOnClickListener(){
            val intent = Intent(this , ExtrasActivity::class.java)
            startActivity(intent)
        }
        ButtonGaseosa.setOnClickListener(){
            val intent = Intent(this , GaseosasActivity::class.java)
            startActivity(intent)
        }

        ButtonRefresco.setOnClickListener(){
            val intent = Intent(this , RefrescosActivity::class.java)
            startActivity(intent)
        }
        ButtonCerveza.setOnClickListener(){
            val intent = Intent(this , CervezasActivity::class.java)
            startActivity(intent)
        }
        ButtonPostres.setOnClickListener(){
            val intent = Intent(this , PostresActivity::class.java)
            startActivity(intent)
        }

        ButtonAcerca.setOnClickListener(){
            val intent = Intent(this , AcercadeActivity::class.java)
            startActivity(intent)
        }
        ButtonAdmin.setOnClickListener(){
            val intent = Intent(this , AdminActivity::class.java)
            startActivity(intent)
        }


    }
}