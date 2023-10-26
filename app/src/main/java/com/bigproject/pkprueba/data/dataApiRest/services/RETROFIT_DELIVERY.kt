package com.bigproject.pkprueba.data.dataApiRest.services

import android.os.Build
import com.bigproject.pkprueba.BuildConfig
import com.bigproject.pkprueba.helper.UtilidadesHelper.Companion.widthDevice
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RETROFIT_DELIVERY private constructor() {
    companion object {
        private var sInstancia: RETROFIT_DELIVERY? = null
        private lateinit var sService: ApiService
        lateinit var retrofit: Retrofit

        fun settingService(): ApiService {
            if (sInstancia == null) {
                sInstancia = RETROFIT_DELIVERY()
            }
            return sService
        }

        fun cleanService() {
            if (sInstancia != null) {
                sInstancia = null
            }
        }

        private val headersDefault: MutableMap<String, String>
            get() {

                val map: MutableMap<String, String> = HashMap()
                map["Accept"] = "application/json"
                map["version-app"] = BuildConfig.VERSION_CODE.toString()
                map["version-name"] = BuildConfig.VERSION_NAME
                map["device-width"] = widthDevice.toString()
                map["device-brand"] = Build.MANUFACTURER
                map["device_name"] = Build.MANUFACTURER
                map["device-model"] = Build.MODEL
                map["device-version-api"] = Build.VERSION.SDK_INT.toString()
                map["device-platform"] = "android"

                return map
            }

        //Setea las cabeceras para el API
        val headers: Map<String, String>
            get() {
                val map: MutableMap<String, String> = headersDefault
                map["Content-Type"] = "application/x-www-form-urlencoded"

                return map
            }

        //Setea las cabeceras para el API
        val headersJsonWithAuthentication: Map<String, String>
            get() {
                val map: MutableMap<String, String> = headersDefault
                map["Content-Type"] = "application/json"

                return map
            }
    }

    init {
        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)
        clientBuilder.connectTimeout(
            BuildConfig.CONNECT_TIMEOUT_RETROFIT.toLong(),
            TimeUnit.SECONDS
        )
        clientBuilder.readTimeout(
            BuildConfig.READ_TIMEOUT_RETROFIT.toLong(),
            TimeUnit.SECONDS
        )

        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()

        sService = retrofit.create(ApiService::class.java)
    }
}