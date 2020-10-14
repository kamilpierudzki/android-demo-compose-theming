package com.example.androidweekly.feature.internal.standardview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.androidweekly.feature.databinding.FeatureFragmentStandardViewBinding
import com.example.androidweekly.feature.internal.FeatureViewModel
import com.viacom.android.neutron.commons.ui.DataBindingFragment

class StandardViewFragment : DataBindingFragment() {

    companion object {
        fun newInstance(): StandardViewFragment = StandardViewFragment()
    }

    private val featureViewModel: FeatureViewModel by activityViewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FeatureFragmentStandardViewBinding.inflate(inflater, container, false).also {
        it.featureViewModel = featureViewModel
    }
}