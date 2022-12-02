package com.example.berywell

import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.berywell.databinding.ActivityPracticeBinding
import java.util.*

class PracticeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPracticeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPracticeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn.setOnClickListener{
            Log.d("lhj", "onCreate: ")
            showStartTimePicker(this)

        }
    }


    private fun showStartTimePicker(context: Context) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        var selectedTime: String = ""
        val listener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            if (hour >= 10 && minute >= 10) {
                selectedTime = "$hour:$minute"
            } else if (hour < 10 && minute >= 10) {
                selectedTime = "0$hour:$minute"
            } else if (hour >= 10 && minute < 10) {
                selectedTime = "$hour:0$minute"
            } else {
                selectedTime = "0$hour:0$minute"
            }
            Log.d("lhj", "Start Time : $selectedTime")
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
                selectedTime = "$hour:$minute"
            } else if (hour < 10 && minute >= 10) {
                selectedTime = "0$hour:$minute"
            } else if (hour >= 10 && minute < 10) {
                selectedTime = "$hour:0$minute"
            } else {
                selectedTime = "0$hour:0$minute"
            }
            Log.d("lhj", "End Time : $selectedTime")
        }
        val picker = TimePickerDialog(context, listener, hour, minute, false)
        picker.setTitle("종료 시간")
        picker.show()
    }

}