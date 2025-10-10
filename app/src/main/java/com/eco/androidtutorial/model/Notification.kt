package com.eco.androidtutorial.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Notification(
    val title: String,
    val content:String,
    val date: Date,
): Parcelable