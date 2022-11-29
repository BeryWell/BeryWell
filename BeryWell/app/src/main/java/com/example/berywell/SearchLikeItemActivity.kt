package com.example.berywell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.berywell.databinding.ActivitySearchLikeBinding

class SearchLikeItemActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchLikeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchLikeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}