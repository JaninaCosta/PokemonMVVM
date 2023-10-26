package com.proyecto.pkprueba.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.proyecto.pkprueba.core.*
import com.proyecto.pkprueba.databinding.ActivitySplashBinding
import com.proyecto.pkprueba.helper.UtilidadesHelper
import java.util.*


@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState, binding.root, this@SplashScreenActivity)
        UtilidadesHelper.llamarPantallaPrincipal()
    }
}