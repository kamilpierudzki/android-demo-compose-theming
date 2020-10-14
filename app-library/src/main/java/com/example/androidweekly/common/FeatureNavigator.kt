package com.example.androidweekly.common

import android.content.Context
import com.example.androidweekly.feature.api.FeatureActivity
import com.example.androidweekly.feature.internal.EntryFeatureFragment
import com.example.androidweekly.feature.internal.FeatureActivityArgument
import com.example.androidweekly.feature.internal.commons.createIntent

class FeatureNavigator {

    fun showComposableInViewScreen(context: Context) {
        FeatureActivity.createIntent(
            context,
            FeatureActivityArgument(EntryFeatureFragment.COMPOSABLE_IN_VIEW)
        ).also {
            context.startActivity(it)
        }
    }

    fun showViewInComposable(context: Context) {
        FeatureActivity.createIntent(
            context,
            FeatureActivityArgument(EntryFeatureFragment.VIEW_IN_COMPOSABLE)
        ).also {
            context.startActivity(it)
        }
    }

    fun showStandardView(context: Context) {
        FeatureActivity.createIntent(
            context,
            FeatureActivityArgument(EntryFeatureFragment.STANDARD_VIEW)
        ).also {
            context.startActivity(it)
        }
    }
}