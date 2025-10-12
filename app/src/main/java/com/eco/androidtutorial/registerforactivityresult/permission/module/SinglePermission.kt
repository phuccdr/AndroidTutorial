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
 * vi sao dung private constructor: Ngăn chặn việc tạo đối tượng từ bên ngoài lớp của cac lớp kế thừa abstract class
 * chỉ được tạo qua các phương thức đã được định nghĩa trong lớp abstract.
 * 
 * Sử dụng WeakReference cho context để tránh memory leak khi Activity/Fragment bị destroy
 */
abstract class SinglePermission private constructor() : Permission {
    abstract val permission: String
    private var onSuccess: (() -> Unit)? = null
    private var onDeny: ((permission: String) -> Unit)? = null
    private var contextRef: WeakReference<Context>? = null
    private var permissionLauncher: ActivityResultLauncher<String>? = null

    constructor(fragment: Fragment) : this() {
        contextRef = WeakReference(fragment.requireContext())
        permissionLauncher = fragment.registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                onSuccess?.invoke()
            } else {
                onDeny?.invoke(permission)
            }
        }
    }

    constructor(activity: AppCompatActivity) : this() {
        contextRef = WeakReference(activity)
        permissionLauncher = activity.registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                onSuccess?.invoke()
            } else {
                onDeny?.invoke(permission)
            }
        }
    }

    override fun isGranted(): Boolean {
        val context = contextRef?.get() ?: return false
        return ContextCompat.checkSelfPermission(
            context, permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun request() {
        permissionLauncher?.launch(permission)
    }

    fun onSuccess(listener: () -> Unit): SinglePermission {
        this.onSuccess = listener
        return this
    }

    fun onDeny(listener: (permission: String) -> Unit): SinglePermission {
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