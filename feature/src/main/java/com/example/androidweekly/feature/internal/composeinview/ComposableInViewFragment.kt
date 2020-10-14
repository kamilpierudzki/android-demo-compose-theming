package com.example.androidweekly.feature.internal.composeinview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.example.androidweekly.feature.R
import com.example.androidweekly.feature.databinding.FeatureFragmentComposableInViewBinding
import com.viacom.android.neutron.commons.ui.DataBindingFragment

class ComposableInViewFragment : DataBindingFragment() {

    companion object {
        fun newInstance(): ComposableInViewFragment = ComposableInViewFragment()
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FeatureFragmentComposableInViewBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            ComposableInViewElementMain()
        }
    }
}