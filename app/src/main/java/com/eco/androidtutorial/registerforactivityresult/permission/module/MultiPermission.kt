package com.eco.androidtutorial.registerforactivityresult.permission.module

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

/**
 * Dung Array dung voi so luong co dinh, co hieu suat truy vấn nhanh
 * List: linh hoạt, cần nhiều phần tử
 *
 * Sử dụng WeakReference cho context để tránh memory leak khi Activity/Fragment bị destroy
 */
abstract class MultiPermission private constructor() : Permission {
    private var contextRef: WeakReference<Context>? = null
    private var permissionLauncher: ActivityResultLauncher<Array<String>>? = null
    abstract val permissions: Array<String>
    private var onSuccess: (() -> Unit)? = null
    private var onDeny: ((permission: Array<String>) -> Unit)? = null

    constructor(fragment: Fragment) : this() {
        contextRef = WeakReference(fragment.requireContext())
        permissionLauncher = fragment.registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { results ->
            /**
             * trả về result với kiểu Map<String,Boolean> trong đó key là tên permission, value là true nếu permission được cấp
             */
            val deniedListPermission = results.filterValues { !it }.keys
            if (deniedListPermission.isEmpty()) {
                onSuccess?.invoke()
            } else {
                onDeny?.invoke(deniedListPermission.toTypedArray())
            }
        }
    }

    constructor(activity: AppCompatActivity) : this() {
        contextRef = WeakReference(activity)
        permissionLauncher = activity.registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { results ->
            val deniedPermissions = results.filterValues { !it }.keys

            if (deniedPermissions.isNotEmpty()) {
                onDeny?.invoke(deniedPermissions.toTypedArray())
            } else {
                onSuccess?.invoke()
            }
        }
    }

    /**
     * Check Permission
     */
    override fun isGranted(): Boolean {
        val context = contextRef?.get() ?: return false
        return permissions.all {
            ContextCompat.checkSelfPermission(
                context, it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    override fun request() {
        permissionLauncher?.launch(permissions)
    }

    fun onSuccess(listener: () -> Unit): MultiPermission {
        this.onSuccess = listener
        return this
    }

    fun onDeny(listener: (permissions: Array<String>) -> Unit): MultiPermission {
        this.onDeny = listener
        return this
    }

    /**
     * Gọi method này để clear resources và tránh memory leak
     * Nên gọi trong onDestroy() của Activity/Fragment
     */
    fun clear() {
        contextRef?.clear()
        contextRef = null
        onSuccess = null
        onDeny = null
        permissionLauncher = null
    }
}