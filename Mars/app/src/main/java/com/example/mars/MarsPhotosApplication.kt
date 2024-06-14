package com.example.mars

import android.app.Application
import com.example.mars.data.AppContainer
import com.example.mars.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}