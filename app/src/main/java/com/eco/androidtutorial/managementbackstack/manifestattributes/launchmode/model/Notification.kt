package com.eco.androidtutorial.managementbackstack.manifestattributes.launchmode.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Notification(
    val title: String,
    val content: String,
    val date: Date,
) : Parcelable {
    override fun toString(): String {
        return """Notification:
            '$title'
             '$content'
                         $date)""".trimMargin()
    }
}