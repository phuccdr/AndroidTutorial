package com.eco.androidtutorial.ui.customview

import android.widget.ImageButton
import androidx.databinding.BindingAdapter

object LayoutButtonBindingAdapter {
    @JvmStatic
    @BindingAdapter("buttonConfig")
    fun ImageButton.setButtonConfig(config: ButtonConfig?) {
        config?.let {
            this.setBackgroundResource(it.backgroundId)
            this.setImageResource(it.iconId)
        }
    }
}
