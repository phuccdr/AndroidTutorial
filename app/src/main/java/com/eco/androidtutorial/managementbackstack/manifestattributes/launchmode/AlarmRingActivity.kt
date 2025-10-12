package com.eco.androidtutorial.managementbackstack.manifestattributes.launchmode

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.R

/**
 * Single Instance: tạo activity chạy trên 1 task riêng và task đó chỉ chứa 1 instance của activity đó
 * Neeus cần mo lại activityloaiji này thì dua task chua activity này vào foreground và gọi onNewIntent
 * Usecase: +) sử dụng
 * Màn hình báo thức, màn hình gọi, hay các màn hình hệ thống.
 *
 */
class AlarmRingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)

    }
}