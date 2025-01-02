package com.pliniodev.experimenting.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.pliniodev.experimenting.navigation.SharedScreen
import com.pliniodev.experimenting.theme.CustomSpacing
import com.pliniodev.experimenting.theme.components.ThemeButton

internal object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val postListScreen = rememberScreen(SharedScreen.FeatureHome)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(CustomSpacing.medium),
        ) {
            ThemeButton(text = "Feature 1") {
                navigator.push(postListScreen)
            }
        }
    }
}