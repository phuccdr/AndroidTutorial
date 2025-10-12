package com.eco.androidtutorial.senddatabetweenactivity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Device(
    val deviceId: String = "",
    val name: String = "",
    val type: String = "",
    val enable: Boolean = true
) : Parcelable {
    override fun toString(): String {
        return "Name: $name, Type: $type, Enable: $enable"

    }
}