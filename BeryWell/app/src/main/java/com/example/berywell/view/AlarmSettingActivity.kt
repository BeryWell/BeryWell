package com.example.berywell.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.berywell.R
import com.example.berywell.databinding.ActivityAlarmSettingBinding

class AlarmSettingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlarmSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAlarmSettingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this@AlarmSettingActivity, MainActivity::class.java)
        startActivity(intent)
    }
}