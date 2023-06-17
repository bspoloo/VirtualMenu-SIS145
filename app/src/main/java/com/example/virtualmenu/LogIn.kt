package com.example.virtualmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.virtualmenu.databinding.ActivityAdminBinding
import com.example.virtualmenu.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = Firebase.auth
        binding.iniciarSesion.setOnClickListener {
            singIn(binding.user.text.toString(), binding.password.text.toString())
        }

    }

    private fun singIn(email: String, password : String){


        if(binding.user.text.toString().isBlank() or binding.password.text.toString().isBlank()){

            Toast.makeText(baseContext,"Por favor ingrese los datos", Toast.LENGTH_LONG).show()
        }
        else{
            firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {task ->
                    if(task.isSuccessful){
//                        val user = firebaseAuth.currentUser
//                        Toast.makeText(baseContext,user?.uid.toString(), Toast.LENGTH_LONG).show()
                        val i = Intent(this, AdminActivity::class.java)
                        startActivity(i)

                    }
                    else{
                        Toast.makeText(baseContext,"Correo o contraseña incorrecta", Toast.LENGTH_LONG).show()
                    }
                }
        }


    }

}