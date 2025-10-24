package com.eco.musicplayer.audioplayer.music

import android.app.Activity
import android.app.Application

class MyApplication : Application() {
    val activityStack = mutableListOf<Activity>()
}
