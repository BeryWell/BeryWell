package com.example.berywell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.widget.Toolbar
import com.example.berywell.databinding.ActivityMyPageBinding

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val toolbar : Toolbar = binding.mypageTb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.mypageUserInfoTv.movementMethod = ScrollingMovementMethod.getInstance()
    }
}