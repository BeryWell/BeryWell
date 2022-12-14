package com.example.berywell.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.berywell.R
import com.example.berywell.databinding.ActivityMainBinding
import com.example.berywell.model.SearchLikeModel

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

        val friedScheduleEventRecyclerViewAdapter = CelebScheduleRecyclerViewAdapter()
        binding.friendRv.adapter = friedScheduleEventRecyclerViewAdapter

        var list : MutableList<SearchLikeModel> = mutableListOf<SearchLikeModel>()
        var frList : MutableList<SearchLikeModel> = mutableListOf<SearchLikeModel>()
        list.add(SearchLikeModel("도널드 트럼프", "미합중국 제45대 대통령", ContextCompat.getDrawable(this, R.drawable.do1)!!))
        list.add(SearchLikeModel("버락 오바마", "미합중국 제 44대 대통령", ContextCompat.getDrawable(this, R.drawable.do2)!!))
        list.add(SearchLikeModel("윈스턴 처칠", "영국 제61・63대 총리", ContextCompat.getDrawable(this, R.drawable.do3)!!))
        list.add(SearchLikeModel("론다 로우지", "미국 여자 종합격투기 선수", ContextCompat.getDrawable(this, R.drawable.do4)!!))
        list.add(SearchLikeModel("베토벤", "서양음악사", ContextCompat.getDrawable(this, R.drawable.do5)!!))

        frList.add(SearchLikeModel("서산", "베리웰 캡스톤 팀장", ContextCompat.getDrawable(this, R.drawable.san)!!))
        frList.add(SearchLikeModel("임형준", "베리웰 캡스톤 팀원", ContextCompat.getDrawable(this, R.drawable.lhj)!!))
        frList.add(SearchLikeModel("공지혁", "베리웰 캡스톤 팀원", ContextCompat.getDrawable(this, R.drawable.kong)!!))

        celebScheduleEventRecyclerViewAdapter.submitSelebScheduleEventList(list)
        friedScheduleEventRecyclerViewAdapter.submitSelebScheduleEventList(frList)


        binding.mainMyBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, MyPageActivity::class.java)
            startActivity(intent)
        }

        binding.mainEditBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, MyScheduleActivity::class.java)
            startActivity(intent)
        }

        binding.mainAlarmBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, AlarmSettingActivity::class.java)
            startActivity(intent)
        }

        binding.recomeendSelebScheduleRv.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchLikeActivity::class.java)
            startActivity(intent)
        }
    }
}