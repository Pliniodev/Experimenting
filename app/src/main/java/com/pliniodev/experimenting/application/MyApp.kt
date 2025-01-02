package com.pliniodev.experimenting.application

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.pliniodev.feature.di.featureScreenModule

class ExperimentingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        
        ScreenRegistry {
            featureScreenModule()
        }
    }
}