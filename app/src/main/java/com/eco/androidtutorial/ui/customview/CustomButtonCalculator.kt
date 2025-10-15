package com.eco.androidtutorial.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import com.eco.androidtutorial.databinding.ButtonCustomCalculatorBinding

class CustomButtonCalculator @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val binding: ButtonCustomCalculatorBinding =
        ButtonCustomCalculatorBinding.inflate(LayoutInflater.from(context), this, true)
    private val background: ImageView = binding.background
    private val iconImage: ImageView = binding.iconImage

    fun setupButtonCalculator(data: ButtonConfig): FrameLayout {
        background.setImageResource(data.iconId)
        iconImage.setImageResource(data.iconId)
        return this
    }

    fun setIconTint(color: Int) {
        iconImage.setColorFilter(color)
    }
}