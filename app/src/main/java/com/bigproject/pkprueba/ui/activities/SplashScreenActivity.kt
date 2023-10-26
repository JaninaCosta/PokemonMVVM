package com.bigproject.pkprueba.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.bigproject.pkprueba.core.*
import com.bigproject.pkprueba.databinding.ActivitySplashBinding
import com.bigproject.pkprueba.helper.UtilidadesHelper
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