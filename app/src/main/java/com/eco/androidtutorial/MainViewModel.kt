package com.eco.androidtutorial

import androidx.lifecycle.ViewModel
import com.eco.androidtutorial.model.Device
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel(
) {
    private val _devices = MutableStateFlow<List<Device>>(emptyList())
    val devices get() = _devices.asStateFlow()

    fun fetchData() {
        _devices.value = listOf(Device("001", "ReadMe", "SmartPhone", true))
    }
}