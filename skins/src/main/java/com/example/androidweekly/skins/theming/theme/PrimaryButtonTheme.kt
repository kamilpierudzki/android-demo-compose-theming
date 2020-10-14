package com.example.androidweekly.skins.theming.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.staticAmbientOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.example.androidweekly.skins.theming.resource.getPrimaryButtonColorForCurrentBrand
import com.example.androidweekly.skins.theming.resource.getPrimaryButtonShapeForCurrentBrand
import com.example.androidweekly.skins.theming.resource.getPrimaryButtonTypographyForCurrentBrand

@Composable
fun PrimaryButtonTheme(
    content: @Composable () -> Unit
) {
    ProvidePrimaryButton(
        color = getPrimaryButtonColorForCurrentBrand(),
        shape = getPrimaryButtonShapeForCurrentBrand(),
        typography = getPrimaryButtonTypographyForCurrentBrand()
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object PrimaryButtonTheme {
    @Composable
    val colors: PrimaryButtonColor
        get() = PrimaryButtonColorAmbient.current

    @Composable
    val shape: PrimaryButtonShape
        get() = PrimaryButtonShapeAmbient.current

    @Composable
    val typography: PrimaryButtonTypography
        get() = PrimaryButtonTypographyAmbient.current
}

data class PrimaryButtonColor(
    val textColor: Color,
    val gradient: List<Color>,
    val inactiveGradient: List<Color>
)

data class PrimaryButtonShape(
    val bodyShape: Shape,
    val minHeight: Dp,
    val paddingStart: Dp,
    val paddingEnd: Dp
)

data class PrimaryButtonTypography(val typography: Typography)

@Composable
internal fun ProvidePrimaryButton(
    color: PrimaryButtonColor,
    shape: PrimaryButtonShape,
    typography: PrimaryButtonTypography,
    content: @Composable () -> Unit
) {
    Providers(
        PrimaryButtonColorAmbient provides color,
        PrimaryButtonShapeAmbient provides shape,
        PrimaryButtonTypographyAmbient provides typography,
        children = content
    )
}

private val PrimaryButtonColorAmbient = staticAmbientOf<PrimaryButtonColor> {
    error("No PrimaryButtonColor provided")
}

private val PrimaryButtonShapeAmbient = staticAmbientOf<PrimaryButtonShape> {
    error("No PrimaryButtonShape provided")
}

private val PrimaryButtonTypographyAmbient = staticAmbientOf<PrimaryButtonTypography> {
    error("No PrimaryButtonTypography provided")
}