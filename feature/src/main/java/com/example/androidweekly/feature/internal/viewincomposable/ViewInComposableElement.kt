package com.example.androidweekly.feature.internal.viewincomposable

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.LifecycleOwner
import com.example.androidweekly.feature.R
import com.example.androidweekly.feature.databinding.FeatureFragmentStandardViewBinding
import com.example.androidweekly.feature.internal.FeatureViewModel
import com.example.androidweekly.skins.theming.theme.AndroidWeeklyDemoAppTheme

@Composable
fun ViewInComposableElementMain(lifecycleOwner: LifecycleOwner) {
    AndroidWeeklyDemoAppTheme {
        ViewInComposableElement(
            lifecycleOwner = lifecycleOwner,
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        )
    }
}

@Composable
fun ViewInComposableElement(
    lifecycleOwner: LifecycleOwner,
    modifier: Modifier = Modifier
) {
    val resources = ContextAmbient.current
    val featureViewModel: FeatureViewModel = viewModel()
    Column(modifier = modifier) {
        Text(
            text = resources.getString(R.string.feature_view_in_composable_title),
            style = MaterialTheme.typography.h3,
            color = AndroidWeeklyDemoAppTheme.colors.StyleH3TextColor
        )
        AndroidViewBinding(FeatureFragmentStandardViewBinding::inflate) {
            this.featureViewModel = featureViewModel
            this.lifecycleOwner = lifecycleOwner
        }
    }
}