package com.eco.androidtutorial.ui.calculator

import com.eco.androidtutorial.R

data class ButtonConfig(
    val iconId: Int,
    val backgroundId: Int = R.drawable.bg_button_normal,
    val weight: Float = 0f,
    val ratio: Float = 0f
)