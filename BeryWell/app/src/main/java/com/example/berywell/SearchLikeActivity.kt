package com.example.berywell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.widget.Toolbar
import com.example.berywell.databinding.ActivitySearchLikeBinding

class SearchLikeActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchLikeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchLikeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar : Toolbar = binding.searchLikeTb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.userInfoTv.movementMethod = ScrollingMovementMethod.getInstance()
    }
}