package com.eco.musicplayer.audioplayer.music.managementbackstack.intentflag

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eco.music.R

/**
 * Nếu activity gọi đã trong task thì clear các activity trên nó và đẩy nó lên đỉnh,
 * nếu ko ở trên đỉnh stack tạo instance mới
 */
class ClearTopFlagActivity : AppCompatActivity() {
    private val TAG = "ClearTopFlagActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_clear_top_flag)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}