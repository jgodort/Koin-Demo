package com.jgodort.koindemo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinDemoApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidContext(this@KoinDemoApplication)
      modules(applicationModule)
    }
  }
}