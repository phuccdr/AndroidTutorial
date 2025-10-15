package com.eco.androidtutorial.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.eco.androidtutorial.databinding.CustomLinearLayoutCalculatorBinding

class CustomLinearLayoutCalculator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {
    private val binding =
        CustomLinearLayoutCalculatorBinding.inflate(LayoutInflater.from(context), this, true)
    val spaces: MutableList<Int> = mutableListOf()
    val buttons: MutableList<CustomButtonCalculator> = mutableListOf()

    init {
        VERTICAL
        setupView()
    }

    private fun setupView() {

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        createButtons(h)
    }

    private fun createButtons(h: Int) {
        
    }
}