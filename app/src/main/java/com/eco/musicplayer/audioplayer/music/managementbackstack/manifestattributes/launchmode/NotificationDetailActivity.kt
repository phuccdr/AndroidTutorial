package com.eco.musicplayer.audioplayer.music.managementbackstack.manifestattributes.launchmode

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.music.databinding.ActivityNotificationBinding
import com.eco.musicplayer.audioplayer.music.managementbackstack.manifestattributes.launchmode.model.Notification
import com.eco.musicplayer.audioplayer.music.utils.logTasksAndBackstack
import java.util.Date

private val TAG = "NotificationActivity"

/**
 * Single Top: Nếu activity đang trên  đỉnh backstack goi onNewIntent() và không tạo instance mới, nếu không trên đỉnh stack tạo instance mới như thường thường.
 * Usecase:+) Notification handing: Nếu người dùng tap vào thông báo mới, nếu Notificaton đang được hiển thị ( trên đinh backstack)
 * Không tạo mới NotificationActivity mà gọi onNewIntent() để handle intent.
 * +) Search or Results Page: tương tự nếu màn hình đang hiển thị result khi search thì không tạo instance mới mà gọi onNewIntent() để handle intent.
 */
class NotificationDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        logTasksAndBackstack(this)
    }

    private fun setupUI() {
        binding.btnOpenNewNotification.setOnClickListener {
            count++
            val intent = Intent(this, NotificationDetailActivity::class.java)
            intent.putExtra(
                "Notification $count", Notification(
                    "New Notification", "New Notification", Date()
                )
            )
            startActivity(intent)
        }
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
        Log.d(
            TAG,
            "onNewIntent running, biến count vẫn giữ nguyên không thay đổi và thông báo mới được xử lý"
        )
    }

    private fun handleIntent(intent: Intent) {
        val newNotification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("notification", Notification::class.java)
        } else {
            @Suppress("DEPRECATION") intent.getParcelableExtra("notification")
        }
        binding.notification = newNotification

    }

}