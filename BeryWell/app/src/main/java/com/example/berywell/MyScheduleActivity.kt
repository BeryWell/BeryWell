package com.example.berywell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.berywell.databinding.ActivityMyScheduleBinding

class MyScheduleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyScheduleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMyScheduleBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar : Toolbar = binding.myScheduleTb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }
}