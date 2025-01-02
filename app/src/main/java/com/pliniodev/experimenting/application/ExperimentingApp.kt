package com.pliniodev.experimenting.application

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.pliniodev.experimenting.di.appModule
import com.pliniodev.feature.di.featureModule
import com.pliniodev.feature.di.featureScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ExperimentingApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ExperimentingApp)
            modules(
                appModule,
                featureModule,
            )
        }

        ScreenRegistry {
            featureScreenModule()
        }
    }
}