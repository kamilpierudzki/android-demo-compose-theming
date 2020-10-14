package com.example.androidweekly.skins.theming.resource

import androidx.compose.runtime.Composable
import com.example.androidweekly.skins.theming.abcPlusBrandName
import com.example.androidweekly.skins.theming.getBrandName
import com.example.androidweekly.skins.theming.qwertyPlusBrandName
import com.example.androidweekly.skins.theming.theme.AndroidWeeklyDemoAppColor

@Composable
fun getAndroidWeeklyDemoAppColorsForCurrentBrand(): AndroidWeeklyDemoAppColor {
    return when (getBrandName()) {
        qwertyPlusBrandName -> com.example.androidweekly.skins.theming.qwertyPlus.AndroidWeeklyDemoAppColorPalette
        abcPlusBrandName -> com.example.androidweekly.skins.theming.abcPlus.AndroidWeeklyDemoAppColorPalette
        else -> throw IllegalStateException("Brand doesn't match")
    }
}