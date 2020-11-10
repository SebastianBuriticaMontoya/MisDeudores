package com.edwinacubillos.misdeudores.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.ui.buscar.BuscarFragment
import com.edwinacubillos.misdeudores.ui.crear.CrearFragment

class MainActivity : AppCompatActivity() {

    private val manager = supportFragmentManager
    private var transaction = manager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val crearFragment = CrearFragment()
        transaction.add(R.id.contenedor, crearFragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        transaction = manager.beginTransaction()
        when (item.itemId) {
            R.id.nav_crear -> {
                val crearFragment = CrearFragment()
                transaction.replace(R.id.contenedor, crearFragment).commit()
            }
            R.id.nav_buscar -> {
                val buscarFragment = BuscarFragment()
                transaction.replace(R.id.contenedor, buscarFragment).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}