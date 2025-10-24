package com.eco.musicplayer.audioplayer.music.ui.unlock

import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.eco.music.R
import com.eco.musicplayer.audioplayer.music.ui.paywallonboaring.StateTrial

@BindingAdapter("setIntroductionVisibility")
fun TextView.setIntroductionVisibility(stateTrial: StateTrial) {
    if (stateTrial == StateTrial.Eligible) {
        text = context.getString(R.string.introductionWeeklyEligible)
    } else if (stateTrial == StateTrial.NotEligible) {
        text = context.getString(R.string.introductionWeeklyNotEligible)
    } else {
        text = ""
    }
}

@BindingAdapter("setBackgroundButton")
fun TextView.setBackgroundButton(stateTrial: StateTrial) {
    val background = background
    var color = context.getColor(R.color.color_0E111B)
    if (stateTrial == StateTrial.Eligible) {
        text = context.getString(R.string.try_for_free)
    } else if (stateTrial == StateTrial.NotEligible) {
        text = context.getString(R.string.continue1)
    } else {
        text = ""
    }
    if (stateTrial != StateTrial.Loading) {
        color = context.getColor(R.color.color_0E111B)
    } else {
        color = context.getColor(R.color.color_5F5F5F)
    }
    if (background is GradientDrawable) {
        val drawable = background.mutate() as GradientDrawable
        drawable.setColor(color)
        this.background = drawable
    }
}