package com.example.androidweekly.skins.theming

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ContextAmbient
import com.example.androidweekly.skins.R

@Composable
internal fun getBrandName(): String {
    val resources = ContextAmbient.current.resources
    val brand = resources.getString(R.string.brand)
    return brand
}

val qwertyPlusBrandName = "qwertyPlus"
val abcPlusBrandName = "abcPlus"