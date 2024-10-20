package com.itariya.kakezan

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class KakezanApp : Application() {
//    companion object {
//        var db: AppDatabase? = null
//    }
    override fun onCreate() {
        super.onCreate()
        // Roomのインスタンスを生成
//        db = Room.databaseBuilder(applicationContext,
//            AppDatabase::class.java, "pokemon_db").build()

        // Timberの初期化
        Timber.plant(Timber.DebugTree())
    }
}