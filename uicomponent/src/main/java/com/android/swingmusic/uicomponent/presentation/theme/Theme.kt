package com.android.swingmusic.uicomponent.presentation.theme

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val blackColorScheme = darkColorScheme(
    primary = neutral200,
    onPrimary = neutral900,
    primaryContainer = neutral800,
    onPrimaryContainer = neutral50,
    secondary = neutral300,
    onSecondary = neutral900,
    secondaryContainer = neutral800,
    onSecondaryContainer = neutral50,
    tertiary = neutral200,
    onTertiary = neutral900,
    tertiaryContainer = neutral800,
    onTertiaryContainer = neutral50,
    error = destructive,
    onError = neutral950,
    errorContainer = destructiveContainer,
    onErrorContainer = onDestructiveContainer,
    background = neutral950,
    onBackground = neutral50,
    surface = neutral950,
    onSurface = neutral50,
    surfaceVariant = neutral800,
    onSurfaceVariant = neutral400,
    outline = borderWhite10,
    outlineVariant = borderWhite10,
    inverseSurface = neutral200,
    inverseOnSurface = neutral900,
    inversePrimary = neutral900,
    surfaceTint = neutral200,
    scrim = Color.Black,
    surfaceContainerLowest = surfaceLowest,
    surfaceContainerLow = surfaceLow,
    surfaceContainer = neutral900,
    surfaceContainerHigh = surfaceHigh,
    surfaceContainerHighest = neutral800,
)

@Composable
fun SwingMusicTheme(
    navBarColor: Color? = null,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val activity = view.context as ComponentActivity
            val effectiveNavBarColor =
                (navBarColor ?: blackColorScheme.inverseOnSurface).toArgb()
            activity.enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.dark(Color.Transparent.toArgb()),
                navigationBarStyle = SystemBarStyle.dark(effectiveNavBarColor)
            )
        }
    }

    MaterialTheme(
        colorScheme = blackColorScheme,
        typography = Typography,
        content = content
    )
}
