package com.pliniodev.experimenting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.pliniodev.experimenting.screens.HomeScreen
import com.pliniodev.experimenting.theme.ExperimentingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExperimentingTheme {
                Navigator(HomeScreen)
            }
        }
    }
}