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

        val myScheduleEventRecyclerViewAdapter = MyScheduleRecyclerViewAdapter()
        binding.myScheduleRv.adapter = myScheduleEventRecyclerViewAdapter

        var list : MutableList<MyScheduleEvent> = mutableListOf<MyScheduleEvent>()
        list.add(MyScheduleEvent("아침 식사", "08:00 ~ 09:00"))
        list.add(MyScheduleEvent("아침 운동", "09:00 ~ 11:00"))
        list.add(MyScheduleEvent("미팅", "11:30 ~ 13:00"))
        list.add(MyScheduleEvent("낮잠", "14:00 ~ 16:00"))

        myScheduleEventRecyclerViewAdapter.submitMyScheduleEventList(list)

    }
}