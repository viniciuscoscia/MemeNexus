package com.viniciuscoscia.memenexus.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

@Composable
fun MemeNexusTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = PrimaryColor,
            surfaceContainer = DarkSurface,
            onSurface = SurfacePrimary
        ),
        typography = Typography(),
        content = content
    )
}