package com.example.berywell.view

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.example.berywell.R
import com.example.berywell.databinding.ActivityMyScheduleBinding
import com.example.berywell.databinding.ActivityScheduleAddBinding
import com.example.berywell.model.ScheduleResult
import com.example.berywell.network.data.request.ScheduleRequest
import com.example.berywell.viewmodel.ScheduleViewModel
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityScheduleAddBinding
    val viewModel: ScheduleViewModel by viewModels()
    var startTime = ""
    var endTime = ""
    var scheduleList : ArrayList<ScheduleResult> = ArrayList<ScheduleResult>()
    var timeStr : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityScheduleAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar : Toolbar = binding.myScheduleTb


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        var myScheduleEventRecyclerViewAdapter = MyScheduleRecyclerViewAdapter()
        binding.myScheduleRv.adapter = myScheduleEventRecyclerViewAdapter

        var list = mutableListOf<MyScheduleEvent>()

        binding.scheduleAddBt.setOnClickListener{
            showStartTimePicker(this)
        }

        var title : EditText = binding.scheduleAddTitleEt

        var index: Int = 0
        binding.myScheduleIv.setOnClickListener {

            scheduleList.add(index, ScheduleResult(title.text.toString(), startTime, endTime))
            list.add(MyScheduleEvent("${title.text}", "$startTime ~ $endTime"))

            myScheduleEventRecyclerViewAdapter.submitMyScheduleEventList(list)

            index++
        }

        myScheduleEventRecyclerViewAdapter.submitMyScheduleEventList(list)

        binding.schedulePostBt.setOnClickListener {
            timeStr = LocalDateTime.now().toString()
            viewModel.sendScheduleList(
                scheduleRequest = ScheduleRequest(timeStr, "lhj", schedules = scheduleList),
                showToast = ::showToast
            )

            val intent = Intent(this@ScheduleAddActivity, MyScheduleActivity::class.java)
            intent.putExtra("timeStr", timeStr)
            startActivity(intent)
        }

    }

    private fun showStartTimePicker(context: Context) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        var selectedTime: String = ""
        val listener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            if (hour >= 10 && minute >= 10) {
                selectedTime = "$hour:$minute:00"
            } else if (hour < 10 && minute >= 10) {
                selectedTime = "0$hour:$minute:00"
            } else if (hour >= 10 && minute < 10) {
                selectedTime = "$hour:0$minute:00"
            } else {
                selectedTime = "0$hour:0$minute:00"
            }
            Log.d("lhj", "Start Time : $selectedTime")
            startTime = selectedTime
        }
        showEndTimePicker(context)

        val picker = TimePickerDialog(context, listener, hour, minute, false)
        picker.setTitle("시작 시간")
        picker.show()


    }


    private fun showEndTimePicker(context: Context) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        var selectedTime: String = ""
        val listener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            if (hour >= 10 && minute >= 10) {
                selectedTime = "$hour:$minute:00"
            } else if (hour < 10 && minute >= 10) {
                selectedTime = "0$hour:$minute:00"
            } else if (hour >= 10 && minute < 10) {
                selectedTime = "$hour:0$minute:00"
            } else {
                selectedTime = "0$hour:0$minute:00"
            }
            Log.d("lhj", "End Time : $selectedTime")
            endTime = selectedTime
        }
        val picker = TimePickerDialog(context, listener, hour, minute, false)
        picker.setTitle("종료 시간")
        picker.show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}