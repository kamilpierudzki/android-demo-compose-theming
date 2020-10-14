package com.example.androidweekly.feature.internal.viewincomposable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class ViewInComposableFragment : Fragment() {

    companion object {
        fun newInstance(): ViewInComposableFragment = ViewInComposableFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ViewInComposableElementMain(lifecycleOwner = viewLifecycleOwner)
            }
        }
    }
}