package com.example.androidweekly.feature.internal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class FeatureViewModel: ViewModel() {

    private val _clicksCount = MutableLiveData(0)
    val clicksCount: LiveData<String> = _clicksCount.map {
        it.toString()
    }

    val default = "dupa123"

    fun onSubmitPressed() {
        _clicksCount.value = _clicksCount.value!! + 1
    }
}