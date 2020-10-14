package com.example.androidweekly.skins.theming.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.staticAmbientOf
import androidx.compose.ui.graphics.Color
import com.example.androidweekly.skins.theming.all.shapes
import com.example.androidweekly.skins.theming.resource.getAndroidWeeklyDemoAppColorsForCurrentBrand
import com.example.androidweekly.skins.theming.all.typography

@Composable
fun AndroidWeeklyDemoAppTheme(
    content: @Composable () -> Unit
) {
    val color = getAndroidWeeklyDemoAppColorsForCurrentBrand()
    ProvideAndroidWeeklyDemoApp(
        color = color
    ) {
        MaterialTheme(
            colors = color.defaults,
            shapes = shapes,
            typography = typography,
            content = content
        )
    }
}

data class AndroidWeeklyDemoAppColor(
    val defaults: Colors,
    val StyleH3TextColor: Color
)

object AndroidWeeklyDemoAppTheme {
    @Composable
    val colors: AndroidWeeklyDemoAppColor
        get() = AndroidWeeklyDemoAppColorAmbient.current
}

@Composable
fun ProvideAndroidWeeklyDemoApp(
    color: AndroidWeeklyDemoAppColor,
    content: @Composable () -> Unit
) {
    Providers(
        AndroidWeeklyDemoAppColorAmbient provides color,
        children = content
    )
}

private val AndroidWeeklyDemoAppColorAmbient = staticAmbientOf<AndroidWeeklyDemoAppColor> {
    error("No AndroidWeeklyDemoAppColor provided")
}