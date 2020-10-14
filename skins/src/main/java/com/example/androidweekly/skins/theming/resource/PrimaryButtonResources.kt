package com.example.androidweekly.skins.theming.resource

import androidx.compose.runtime.Composable
import com.example.androidweekly.skins.theming.abcPlusBrandName
import com.example.androidweekly.skins.theming.getBrandName
import com.example.androidweekly.skins.theming.qwertyPlusBrandName
import com.example.androidweekly.skins.theming.theme.PrimaryButtonColor
import com.example.androidweekly.skins.theming.theme.PrimaryButtonShape
import com.example.androidweekly.skins.theming.theme.PrimaryButtonTypography

@Composable
fun getPrimaryButtonColorForCurrentBrand(): PrimaryButtonColor {
    return when (getBrandName()) {
        qwertyPlusBrandName -> com.example.androidweekly.skins.theming.qwertyPlus.PrimaryButtonColor
        abcPlusBrandName -> com.example.androidweekly.skins.theming.abcPlus.PrimaryButtonColor
        else -> throw IllegalStateException("Brand doesn't match")
    }
}

@Composable
fun getPrimaryButtonShapeForCurrentBrand(): PrimaryButtonShape {
    return when (getBrandName()) {
        qwertyPlusBrandName -> com.example.androidweekly.skins.theming.qwertyPlus.PrimaryButtonShape
        abcPlusBrandName -> com.example.androidweekly.skins.theming.abcPlus.PrimaryButtonShape
        else -> throw IllegalStateException("Brand doesn't match")
    }
}

@Composable
fun getPrimaryButtonTypographyForCurrentBrand(): PrimaryButtonTypography {
    return when (getBrandName()) {
        qwertyPlusBrandName -> com.example.androidweekly.skins.theming.qwertyPlus.PrimaryButtonTypography
        abcPlusBrandName -> com.example.androidweekly.skins.theming.abcPlus.PrimaryButtonTypography
        else -> throw IllegalStateException("Brand doesn't match")
    }
}