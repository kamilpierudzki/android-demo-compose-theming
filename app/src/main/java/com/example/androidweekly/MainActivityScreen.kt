package com.example.androidweekly

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidweekly.commons.primarybutton.PrimaryButton
import com.example.androidweekly.skins.theming.theme.PrimaryButtonTheme

@Composable
fun MainActivityScreen(
    onComposableInView: () -> Unit,
    onViewInComposable: () -> Unit,
    onStandardView: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        val spacerModifier = Modifier.height(56.dp)
        Spacer(modifier = spacerModifier)
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            PrimaryButtonTheme {
                PrimaryButton(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onClick = onComposableInView
                ) {
                    Text("Jetpack Composable in View")
                }
            }
        }
        Spacer(modifier = spacerModifier)
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            PrimaryButtonTheme {
                PrimaryButton(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onClick = onViewInComposable
                ) {
                    Text("View in Jetpack Composable")
                }
            }
        }
        Spacer(modifier = spacerModifier)
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            PrimaryButtonTheme {
                PrimaryButton(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onClick = onStandardView
                ) {
                    Text("Standard android view")
                }
            }
        }
    }
}