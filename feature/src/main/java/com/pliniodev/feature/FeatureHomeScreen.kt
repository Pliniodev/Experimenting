package com.pliniodev.feature

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class FeatureHomeScreen : Screen {
    @Composable
    override fun Content() {
        Text(text = "Feature Home Screen")
    }
}