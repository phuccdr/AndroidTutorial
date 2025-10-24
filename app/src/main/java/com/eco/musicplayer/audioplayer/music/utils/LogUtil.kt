package com.eco.musicplayer.audioplayer.music.utils

import android.app.ActivityManager
import android.content.Context
import android.util.Log

private val TAG = "TASK_LOG"
fun logTasksAndBackstack(context: Context) {
    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val tasks = activityManager.appTasks
    Log.d(TAG, "===== Current Tasks (${tasks.size}) =====")

    for (task in tasks) {
        val taskInfo = task.taskInfo
        Log.d(TAG, "Task ID: ${taskInfo.taskId}")
        Log.d(TAG, "Base Activity: ${taskInfo.baseActivity}")
        Log.d(TAG, "Top Activity: ${taskInfo.topActivity}")
        Log.d(TAG, "Num Activities: ${taskInfo.numActivities}")
        Log.d(TAG, "Running: ${taskInfo.isRunning}")
        Log.d(TAG, "---------------------------------------")
    }
}
