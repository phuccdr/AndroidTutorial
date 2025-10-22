package com.eco.androidtutorial.ui

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("state", "targetState")
fun View.setVisibilityWithLoadingState(state: LoadingState, targetState: LoadingState) {
    visibility = if (state == targetState) View.VISIBLE else View.INVISIBLE
}