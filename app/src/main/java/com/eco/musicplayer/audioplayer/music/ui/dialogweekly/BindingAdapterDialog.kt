package com.eco.musicplayer.audioplayer.music.ui.dialogweekly

import android.view.View
import androidx.databinding.BindingAdapter
import com.eco.musicplayer.audioplayer.music.ui.LoadingState

@BindingAdapter("state", "targetState")
fun View.setVisibilityWithLoadingState(state: LoadingState, targetState: LoadingState) {
    visibility = if (state == targetState) View.VISIBLE else View.INVISIBLE
}