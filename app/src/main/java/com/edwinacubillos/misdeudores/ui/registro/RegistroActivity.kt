
package com.edwinacubillos.misdeudores.ui.registro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.dao.UsuarioDAO
import com.edwinacubillos.misdeudores.data.database.entities.Usuario
import com.edwinacubillos.misdeudores.databinding.FragmentCrearBinding
import com.edwinacubillos.misdeudores.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registro.*
import java.sql.Types.NULL

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: FragmentCrearBinding

    companion object {
        private const val EMPTY = ""
        private const val SPACE = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        registrar_button.setOnClickListener {
            val email = correo_edit_text.text.toString()
            val contrasena = contrasena_edit_text.text.toString()
            val repcontrasena = rep_contrasena_edit_text.text.toString()

            if (contrasena == repcontrasena) {
                if (contrasena.length >= 6) {

                    val usuario = Usuario(NULL, email, contrasena)
                    val usuarioDAO: UsuarioDAO = MisDeudores.database.UsuarioDAO()

                    usuarioDAO.insertUsuario(usuario)

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Contraseña demasiado corta", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Contraseña no coincide", Toast.LENGTH_SHORT).show()
            }
        }
    }



    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Método", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Método", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Método", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Método", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Método", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Método", "onRestart")
    }
}






