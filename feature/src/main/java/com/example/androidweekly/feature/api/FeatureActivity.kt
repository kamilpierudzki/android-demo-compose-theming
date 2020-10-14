package com.example.androidweekly.feature.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidweekly.feature.internal.EntryFeatureFragment
import com.example.androidweekly.feature.internal.FeatureActivityArgument
import com.example.androidweekly.feature.internal.FeatureFragmentNavigator
import com.example.androidweekly.feature.internal.commons.ActivityCreator

class FeatureActivity : AppCompatActivity() {

    companion object : ActivityCreator<FeatureActivityArgument>(FeatureActivity::class)

    private lateinit var navigator: FeatureFragmentNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        if (savedInstanceState == null) {
            showEntryPointFragment()
        }
    }

    private fun init() {
        navigator = FeatureFragmentNavigator(supportFragmentManager)
    }

    private fun showEntryPointFragment() {
        when (argument.entryFeatureFragment) {
            EntryFeatureFragment.VIEW_IN_COMPOSABLE ->
                navigator.showViewInComposable(clearBackStack = true)
            EntryFeatureFragment.COMPOSABLE_IN_VIEW ->
                navigator.showComposableInView(clearBackStack = true)
            EntryFeatureFragment.STANDARD_VIEW ->
                navigator.showStandardView(clearBackStack = true)
        }
    }
}