package com.eco.androidtutorial.senddatabetweenactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivitySenderBinding

/**
 * Lưu ý: Android không cho phép gửi dữ liệu lớn giữa các thành phần (Activity, Service, BroadcastReceiver) thông qua Intent, Bundle, hoặc Parcel.
 * Dữ liệu đươc gửi qua Intent phải có dung lượng <2KB nếu không bị ném exception TransactionTooLargeException.
 * Khi gửi dữ liệu qua intent OS sẽ lấy bundle trong intent gửi lên rồi, nhị phân (Parcel : Lý do vì sao cần anotation @Parcelize cho đối tượng gửi qua intent) data trong bundle
 * gửi dữ liệu quan binder IPC (Inter -Process Communication) ? là cái gì ??? :))
 */
class SenderActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySenderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnSendDataIntent.setOnClickListener {
                val intent = Intent(this@SenderActivity, ReceiverActivity::class.java)
                intent.putExtra("SendDataFromIntent", "SendDataFromIntent")
                startActivity(intent)
            }
            btnSendDataBundle.setOnClickListener {
                val intent = Intent(this@SenderActivity, ReceiverActivity::class.java)
                val bundle = Bundle().apply {
                    putParcelable("Device1", Device("1", "Samsung", "Phone"))
                    putParcelable("Device2", Device("2", "Samsung", "Phone"))
                }
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}