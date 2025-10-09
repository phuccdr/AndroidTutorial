package com.eco.androidtutorial

import android.graphics.Camera
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle

class CameraComponent(private val lifecycle: Lifecycle) : DefaultLifecycleObserver {

    private var camera: Camera? = null

    init {
        lifecycle.addObserver(this)
    }

    fun initializeCamera() {
        if (camera == null) {
            getCamera()
        }
    }

    fun releaseCamera() {
       // camera?.release()
        camera = null
    }

    private fun getCamera() {
        // Code mở camera
    }
}
