package com.example.androidweekly.feature.internal.composeinview

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.example.androidweekly.commons.primarybutton.PrimaryButton
import com.example.androidweekly.feature.R
import com.example.androidweekly.feature.internal.FeatureViewModel
import com.example.androidweekly.skins.theming.theme.AndroidWeeklyDemoAppTheme
import com.example.androidweekly.skins.theming.theme.PrimaryButtonTheme

@Composable
fun ComposableInViewElementMain() {
    AndroidWeeklyDemoAppTheme {
        ComposableInViewElement(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        )
    }
}

@Composable
fun ComposableInViewElement(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        val resources = ContextAmbient.current
        val featureViewModel: FeatureViewModel = viewModel()
        Text(
            text = resources.getString(R.string.feature_composable_title),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h3,
            color = AndroidWeeklyDemoAppTheme.colors.StyleH3TextColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            PrimaryButtonTheme {
                PrimaryButton(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onClick = featureViewModel::onSubmitPressed
                ) {
                    Text(resources.getString(R.string.feature_button))
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        val clicksCountState = featureViewModel.clicksCount.observeAsState()
        Text(
            text = clicksCountState.value ?: "",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.primary
        )
    }
}