package com.eco.musicplayer.audioplayer.music.registerforactivityresult.common

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.eco.music.databinding.ActivityRegisterForResultExampleBinding

/**
 * registerForActivityResult() là cái gì ? hoạt động ntn?
 * Trong ComponentActivity và Fragment, Activity Result API cung cấp phương thức registerForActicvityResult() là API để đăng ký xử lý kết quả trả về từ một hoạt động khác.
 * registerForActivityResult gồm 3 thành phần:
 * +) ActivityResultContract: abstract class xác đinh kiểu input và output của hoạt động,
 *                            các loại ActivityResultConstact: ActivityResultContracts.CaptureVideo,ActivityResultConstract.RequestPermission,... được kế thừa từ ActivityResultContract
 *                            có thể tự custom ActivityResultContract bằng cách kế thua abstract class ActivityResultContract
 *
 * +) ActivityResultCallback: interface chứa method onActivityResult() để xử lý kết quả trả về
 * +) ActivityResultLauncher: thực hiện ,kích hoạt.
 *    có thể khai báo registerForActivityResult như 1 biến thành viên của activity nhưng launch nó thì phải created xong mới được launch.
 */
class RegisterForActivityResultExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterForResultExampleBinding
    private val chooseFile =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                binding.tvUriFile.text = result.data?.getStringExtra("result")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterForResultExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.btnNavChooseFile.setOnClickListener {
            val intent = Intent(this, ChooseFileActivity::class.java)
            chooseFile.launch(intent)
        }
    }
}