package com.zvonimirplivelic.hazardousdrinkinggame

import android.app.Application
import timber.log.Timber


class HazardousDrinkingGameApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}