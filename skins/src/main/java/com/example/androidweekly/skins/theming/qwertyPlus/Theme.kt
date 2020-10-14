package com.example.androidweekly.skins.theming.qwertyPlus

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidweekly.skins.theming.all.Eina
import com.example.androidweekly.skins.theming.theme.AndroidWeeklyDemoAppColor
import com.example.androidweekly.skins.theming.theme.PrimaryButtonColor
import com.example.androidweekly.skins.theming.theme.PrimaryButtonShape
import com.example.androidweekly.skins.theming.theme.PrimaryButtonTypography

val PrimaryButtonColor = PrimaryButtonColor(
    textColor = button01_value,
    gradient = listOf(
        colorBrand01Gradient1_value,
        colorBrand01Gradient2_value
    ),
    inactiveGradient = listOf(
        colorBrand01InactiveGradient1_value,
        colorBrand01InactiveGradient2_value
    )
)

val PrimaryButtonShape = PrimaryButtonShape(
    bodyShape = RoundedCornerShape(4.dp),
    minHeight = 44.dp,
    paddingStart = 10.dp,
    paddingEnd = 10.dp
)

val PrimaryButtonTypography = PrimaryButtonTypography(
    typography = Typography(
        button = TextStyle(
            fontFamily = Eina,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
    )
)

val AndroidWeeklyDemoAppColorPalette = AndroidWeeklyDemoAppColor(
    defaults = lightColors(
        primary = my_primary,
        background = colorUI04_value
    ),
    StyleH3TextColor = h3_value
)