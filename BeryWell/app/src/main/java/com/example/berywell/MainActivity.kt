package com.example.berywell

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.berywell.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar : Toolbar = binding.mainTb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.recomeendSelebScheduleRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        val celebScheduleEventRecyclerViewAdapter = CelebScheduleRecyclerViewAdapter()
        binding.recomeendSelebScheduleRv.adapter = celebScheduleEventRecyclerViewAdapter

        var list : MutableList<CelebScheduleEvent> = mutableListOf<CelebScheduleEvent>()
        list.add(CelebScheduleEvent("손석희", "JTBC 뉴스룸 메인 앵커"))
        list.add(CelebScheduleEvent("김동현", "전 종합격투기 선수"))
        list.add(CelebScheduleEvent("김영한", "우아한형제들 기술자"))
        list.add(CelebScheduleEvent("서 산", "제주도 최고 OUTPUT"))

        celebScheduleEventRecyclerViewAdapter.submitSelebScheduleEventList(list)
    }
}