package com.bigproject.appdelivery.core

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bigproject.appdelivery.R

open class BaseActivity : AppCompatActivity() {
    lateinit var contexto : Context

    protected fun onCreate(savedInstanceState: Bundle?, view: View, _context: Context) {
        super.onCreate(savedInstanceState)
        setContentView(view)

        contexto = _context
        setColorPrimaryDark()
    }

    protected fun setColorPrimaryDark() {
        //barra de estado advance
        window.statusBarColor = ContextCompat.getColor(this,R.color.colorPrimaryDark)
    }

}