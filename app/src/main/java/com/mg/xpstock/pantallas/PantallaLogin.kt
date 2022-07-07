package com.mg.xpstock.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.mg.xpstock.R

class PantallaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_XPStock)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        septup()
    }
    private fun septup(){

        val buttonLogin = findViewById<Button>(R.id.loginButton)
        val user = findViewById<TextView>(R.id.user).text
        val pass = findViewById<TextView>(R.id.pass).text
        buttonLogin.setOnClickListener{
            if(user.isNotEmpty() && pass.isNotEmpty()){
                val userCorreo = "$user@xplcdfactory.com"
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(userCorreo, pass.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            val pasar = Intent(this, PantallaMenu::class.java)
                            startActivity(pasar)
                            finish()
                        }else{
                            showAlert()
                        }
                    }
            }

        }

    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Verifiique si su usuario o contraseña son correctos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}