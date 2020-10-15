package com.example.androidweekly.skins.theming.resource

import androidx.compose.ui.graphics.Color

internal object HexToJetpackColor {
    fun fromHex(hex: String): Color = Color(android.graphics.Color.parseColor(hex))
}