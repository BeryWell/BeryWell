package com.example.berywell.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.berywell.databinding.ActivitySearchLikeBinding
import com.example.berywell.viewmodel.ScheduleViewModel

class SearchLikeActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchLikeBinding
    private val viewModel: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchLikeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.searchLikeTb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.userInfoTv.movementMethod = ScrollingMovementMethod.getInstance()

        binding.userFavorTb.setOnClickListener {
            it.isSelected = !it.isSelected
        }


        binding.searchLikeRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val searchLikeEventRecyclerViewAdapter = SearchLikeRecyclerViewAdapter()
        binding.searchLikeRv.adapter = searchLikeEventRecyclerViewAdapter

        var list: MutableList<SearchLikeEvent> = mutableListOf<SearchLikeEvent>()
        list.add(SearchLikeEvent("아침 식사", "08:00 ~ 09:00"))
        list.add(SearchLikeEvent("아침 운동", "09:00 ~ 11:00"))

        searchLikeEventRecyclerViewAdapter.submitSearchLikeEventList(list)


        binding.btn.setOnClickListener {
            viewModel.getAllScheduleList(::showToast)
        }

        viewModel.allSchedule.observe(this, Observer {
            Log.d("lhj", "Activity : ${it[0].title}")
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}