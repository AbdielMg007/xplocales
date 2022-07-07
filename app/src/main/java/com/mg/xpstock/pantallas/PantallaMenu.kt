package com.mg.xpstock.pantallas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mg.xpstock.R

class PantallaMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_XPStock)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
}