package com.example.virtualmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        val ButtonPlatos = findViewById<Button>(R.id.buttonPlatos) as Button
        val ButtonBebidas = findViewById<Button>(R.id.buttonBebidas) as Button
        val ButtonPostres = findViewById<Button>(R.id.buttonPostres) as Button
        val ButtonSalir = findViewById<Button>(R.id.buttonSalir) as Button
        val ButtonAcerca = findViewById<Button>(R.id.buttonAcerca) as Button
        val ButtonAdmin = findViewById<Button>(R.id.buttonAdmin) as Button

        ButtonPlatos.setOnClickListener(){
            val intent = Intent(this , PlatosActivity::class.java)
            startActivity(intent)
        }
        ButtonBebidas.setOnClickListener(){
            val intent = Intent(this , BebidasActivity::class.java)
            startActivity(intent)
        }

        ButtonPostres.setOnClickListener(){
            val intent = Intent(this , PostresActivity::class.java)
            startActivity(intent)
        }
        ButtonSalir.setOnClickListener(){
            finish()
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