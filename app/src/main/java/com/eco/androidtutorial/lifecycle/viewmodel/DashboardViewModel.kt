package com.eco.androidtutorial.lifecycle.viewmodel

import androidx.lifecycle.ViewModel
import com.eco.androidtutorial.senddatabetweenactivity.Device
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel(
) {
    private val _devices = MutableStateFlow<List<Device>>(emptyList())
    val devices get() = _devices.asStateFlow()

    fun fetchData() {
        _devices.value = listOf(Device("001", "ReadMe", "SmartPhone", true))
    }
}