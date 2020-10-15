package com.example.androidweekly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.androidweekly.skins.theming.theme.AndroidWeeklyDemoAppTheme

class MainActivity : AppCompatActivity() {

    private val featureNavigator = FeatureNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidWeeklyDemoAppTheme {
                MainActivityScreen(
                    onComposableInView = { featureNavigator.showComposableInViewScreen(this) },
                    onViewInComposable = { featureNavigator.showViewInComposable(this) },
                    onStandardView = { featureNavigator.showStandardView(this) },
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidWeeklyDemoAppTheme {
        MainActivityScreen(
            onComposableInView = {},
            onViewInComposable = {},
            onStandardView = {},
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        )
    }
}

