package com.eco.androidtutorial.registerforactivityresult.permission.module

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Permission class để xử lý quyền đọc và ghi external storage
 *
 * Lưu ý về API levels:
 * - Android 10 (API 29): Giới thiệu Scoped Storage
 * - Android 11 (API 30): WRITE_EXTERNAL_STORAGE không còn cấp quyền write vào shared storage
 * - Android 13 (API 33): READ_EXTERNAL_STORAGE được thay thế bởi READ_MEDIA_* permissions
 *
 * Để hỗ trợ Android 13+, cân nhắc sử dụng:
 * - READ_MEDIA_IMAGES
 * - READ_MEDIA_VIDEO
 * - READ_MEDIA_AUDIO
 */
class ReadAnWriteStoragePermission : MultiPermission {
    constructor(fragment: Fragment) : super(fragment)

    constructor(activity: AppCompatActivity) : super(activity)

    override val permissions: Array<String>
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            /** Android 13 (API 33) trở lên - sử dụng granular media permissions*/
            arrayOf(
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.READ_MEDIA_AUDIO
            )
        } else arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE
        )


}