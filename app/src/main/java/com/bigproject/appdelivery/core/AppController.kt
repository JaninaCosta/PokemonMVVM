package com.bigproject.appdelivery.core

import androidx.media3.common.util.UnstableApi
import androidx.media3.database.DatabaseProvider
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.datasource.HttpDataSource
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
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

        @Synchronized
        fun getCacheInstance(): CacheDataSource.Factory {
            if (mCacheInstance == null) {
                // Create an HTTP data source factory
                val httpDataSourceFactory: HttpDataSource.Factory = DefaultHttpDataSource.Factory()
                val databaseProvider: DatabaseProvider = StandaloneDatabaseProvider(mInstance)
                // Create a SimpleCache instance
                val cache = SimpleCache(
                    File(mCacheDir, "videos"),
                    LeastRecentlyUsedCacheEvictor(200 * 1024 * 1024) // 1000 MB cache size
                    , databaseProvider
                )
                // Create a CacheDataSource.Factory
                mCacheInstance = CacheDataSource.Factory()
                    .setCache(cache)
                    .setUpstreamDataSourceFactory(httpDataSourceFactory)
            }
            return mCacheInstance!!
        }
    }
    override fun onCreate() {
        super.onCreate()
        mInstance = this
        mCacheDir = cacheDir
//        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
    }
}