package com.example.androidweekly.feature.internal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.androidweekly.feature.internal.composeinview.ComposeInViewFragment
import com.example.androidweekly.feature.internal.standardview.StandardViewFragment
import com.example.androidweekly.feature.internal.viewincomposable.ViewInComposableFragment

class FeatureFragmentNavigator(
    private val manager: FragmentManager,
) {

    fun showViewInComposable(clearBackStack: Boolean = false) {
        showFragment(ViewInComposableFragment.newInstance(), clearBackStack)
    }

    fun showComposableInView(clearBackStack: Boolean = false) {
        showFragment(ComposeInViewFragment.newInstance(), clearBackStack)
    }

    fun showStandardView(clearBackStack: Boolean = false) {
        showFragment(StandardViewFragment.newInstance(), clearBackStack)
    }

    private fun showFragment(fragment: Fragment, clearBackStack: Boolean = false) {
        manager.beginTransaction().apply {
            replace(android.R.id.content, fragment)
            if (clearBackStack) {
                manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            } else {
                addToBackStack(null)
            }
            commit()
        }
    }
}