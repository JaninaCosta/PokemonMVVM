package com.bigproject.appdelivery.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.bigproject.appdelivery.core.*
import com.bigproject.appdelivery.databinding.ActivitySplashBinding
import com.bigproject.appdelivery.helper.UtilidadesHelper
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