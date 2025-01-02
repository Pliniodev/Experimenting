package com.pliniodev.feature.di

import cafe.adriel.voyager.core.registry.screenModule
import com.pliniodev.experimenting.navigation.SharedScreen
import com.pliniodev.feature.FeatureHomeScreen

val featureScreenModule = screenModule {
    register<SharedScreen.FeatureHome> {
        FeatureHomeScreen()
    }
}