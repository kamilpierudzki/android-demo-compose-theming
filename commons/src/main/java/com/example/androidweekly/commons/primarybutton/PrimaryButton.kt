package com.example.androidweekly.commons.primarybutton

import androidx.compose.foundation.ProvideTextStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.androidweekly.commons.horizontalGradientBackground
import com.example.androidweekly.skins.theming.theme.PrimaryButtonTheme

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = PrimaryButtonTheme.shape.bodyShape,
    backgroundGradient: List<Color> = PrimaryButtonTheme.colors.gradient,
    disabledBackgroundGradient: List<Color> = PrimaryButtonTheme.colors.inactiveGradient,
    contentColor: Color = PrimaryButtonTheme.colors.textColor,
    disabledContentColor: Color = PrimaryButtonTheme.colors.textColor,
    contentPadding: PaddingValues = PaddingValues(
        start = PrimaryButtonTheme.shape.paddingStart,
        end = PrimaryButtonTheme.shape.paddingEnd
    ),
    content: @Composable RowScope.() -> Unit
) {
    PrimaryButtonSurface(
        shape = shape,
        contentColor = if (enabled) contentColor else disabledContentColor,
        modifier = modifier
            .clip(shape)
            .horizontalGradientBackground(
                colors = if (enabled) backgroundGradient else disabledBackgroundGradient
            )
            .clickable(
                onClick = onClick,
                enabled = enabled,
            )
            .height(PrimaryButtonTheme.shape.minHeight)
    ) {
        ProvideTextStyle(
            value = PrimaryButtonTheme.typography.typography.button
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                children = content
            )
        }
    }
}