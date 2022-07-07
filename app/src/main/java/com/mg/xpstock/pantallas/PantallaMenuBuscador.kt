package com.mg.xpstock.pantallas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mg.xpstock.R
import com.mg.xpstock.adapters.adapterTarget

class buscar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_buscador)


    }

    fun buscar(view: View?) {
        var busqueda = findViewById<EditText>(R.id.busqueda).text.toString().replace(" ","")

        if(busqueda.uppercase() == "SAM" || busqueda.uppercase()== "SM"){
            busqueda = "samsung"
        }
        if(busqueda.uppercase() == "HW" || busqueda.uppercase()== "HUA"){
            busqueda = "huawei"
        }
        if(busqueda.uppercase() == "APPLE" || busqueda.uppercase() == "IPH"){
            busqueda = "IPHONE"
        }
        if(busqueda.uppercase() == "MOTOROLA"|| busqueda.uppercase() == "MO"){
            busqueda = "moto"
        }
        if(busqueda.uppercase() == "MI"){
            busqueda = "xiaomi"
        }


        val recyclerView = findViewById<RecyclerView>(R.id.listBusquedas)
        val adapter = adapterTarget(this, busqueda)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}