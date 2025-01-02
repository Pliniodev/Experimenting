package com.pliniodev.experimenting.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object FeatureHome : SharedScreen()
}