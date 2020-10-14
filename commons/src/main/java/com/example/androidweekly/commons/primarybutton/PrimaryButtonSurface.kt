/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.androidweekly.commons.primarybutton

import androidx.compose.foundation.ContentColorAmbient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androidweekly.skins.theming.theme.PrimaryButtonTheme
import kotlin.math.ln

/**
 * An alternative to [androidx.compose.material.Surface] utilizing
 * [com.example.jetsnack.ui.theme.JetsnackColorPalette]
 */
@Composable
fun PrimaryButtonSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    contentColor: Color = PrimaryButtonTheme.colors.textColor,
    elevation: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.drawShadow(elevation = elevation, shape = shape, clip = false)
            .zIndex(elevation.value)
            .background(
                color = getBackgroundColorForElevation(Color.Transparent, elevation),
                shape = shape
            )
            .clip(shape)
    ) {
        Providers(ContentColorAmbient provides contentColor, children = content)
    }
}

@Composable
private fun getBackgroundColorForElevation(color: Color, elevation: Dp): Color {
    return if (elevation > 0.dp // && https://issuetracker.google.com/issues/161429530
        // JetsnackTheme.colors.isDark //&&
        // color == JetsnackTheme.colors.uiBackground
    ) {
        color.withElevation(elevation)
    } else {
        color
    }
}

/**
 * Applies a [Color.White] overlay to this color based on the [elevation]. This increases visibility
 * of elevation for surfaces in a dark theme.
 *
 * TODO: Remove when public https://issuetracker.google.com/155181601
 */
private fun Color.withElevation(elevation: Dp): Color {
    val foreground = calculateForeground(elevation)
    return foreground.compositeOver(this)
}

/**
 * @return the alpha-modified [Color.White] to overlay on top of the surface color to produce
 * the resultant color.
 */
private fun calculateForeground(elevation: Dp): Color {
    val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
    return Color.White.copy(alpha = alpha)
}
