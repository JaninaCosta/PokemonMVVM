package com.proyecto.pkprueba.core

import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.cache.CacheDataSource
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import java.io.File

@UnstableApi @HiltAndroidApp //cambié aquí porque me estaba dando un error de repente con hilt
class AppController : MultiDexApplication() {
    companion object {
        @JvmField val TAG = AppController::class.java.simpleName
        lateinit var mInstance: AppController
        private var mCacheInstance: CacheDataSource.Factory? = null
        private var mCacheDir: File? = null
        @Synchronized
        fun getInstance(): AppController {
            return mInstance
        }
    }
    override fun onCreate() {
        super.onCreate()
        mInstance = this
        mCacheDir = cacheDir
//        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
    }
}