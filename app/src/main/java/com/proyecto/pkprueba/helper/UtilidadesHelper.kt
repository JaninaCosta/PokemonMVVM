package com.proyecto.pkprueba.helper

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.proyecto.pkprueba.core.*
import com.proyecto.pkprueba.ui.activities.ListadoPokemonActivity
import java.io.Serializable
import java.util.*


class UtilidadesHelper {

    companion object {

        @JvmStatic
        @Suppress("DEPRECATION")
        fun isInternetAvailable(context: Context): Boolean {
            var result = false
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cm?.run {
                    cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                        result = when {
                            hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                            hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                            else -> false
                        }
                    }
                }
            } else {
                cm?.run {
                    cm.activeNetworkInfo?.run {
                        if (type == ConnectivityManager.TYPE_WIFI) {
                            result = true
                        } else if (type == ConnectivityManager.TYPE_MOBILE) {
                            result = true
                        }
                    }
                }
            }
            return result
        }



        @JvmStatic
        fun llamarPantallaPrincipal(contexto: Context = AppController.mInstance.applicationContext) {
            val intent: Intent = Intent(contexto, ListadoPokemonActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            contexto.startActivity(intent)
        }

        @JvmStatic
        val widthDevice: Int
            get() = Resources.getSystem().displayMetrics.widthPixels

        @JvmStatic
        fun <T : Serializable?> getSerializable(intent: Intent, key: String, m_class: Class<T>): T {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                intent.getSerializableExtra(key, m_class)!!
            else
                intent.getSerializableExtra(key) as T
        }

    }
}