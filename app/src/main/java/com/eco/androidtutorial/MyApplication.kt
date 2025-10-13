package com.eco.androidtutorial

import android.app.Activity
import android.app.Application

class MyApplication : Application() {
    val activityStack = mutableListOf<Activity>()
}
