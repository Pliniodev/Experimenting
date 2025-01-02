package com.pliniodev.experimenting.theme.components

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
public fun ThemeButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier.background(
            brush = Brush.linearGradient(
                listOf(Color.Blue, MaterialTheme.colorScheme.primaryContainer),
            ),
            shape = MaterialTheme.shapes.extraLarge,
        ),
    ) {
        Text(text = text)
    }
}