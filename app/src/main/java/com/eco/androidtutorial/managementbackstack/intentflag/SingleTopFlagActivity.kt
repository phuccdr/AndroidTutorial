package com.eco.androidtutorial.managementbackstack.intentflag

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eco.androidtutorial.R

/**
 * Nếu activity nó đã được tạo nhưng nằm dưới backstack thì đưa lên đỉnh và gọi onNewIntent(). Nếu không thì tạo mới .
 * Tương tự lauchMode: singleTop.
 */
class SingleTopFlagActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_single_top_flag)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}