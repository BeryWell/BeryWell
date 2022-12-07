package com.example.berywell.view

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.berywell.databinding.ActivityMyScheduleBinding
import com.example.berywell.model.ScheduleModel
import com.example.berywell.model.ScheduleResult
import com.example.berywell.network.data.request.DetailScheduleRequest
import com.example.berywell.network.data.request.ScheduleRequest
import com.example.berywell.network.data.response.DetailScheduleResponse
import com.example.berywell.viewmodel.ScheduleViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class MyScheduleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyScheduleBinding
    val viewModel: ScheduleViewModel by viewModels()
    var timeStr: String = ""
    var scheduleList: ArrayList<DetailScheduleResponse> = ArrayList<DetailScheduleResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMyScheduleBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.myScheduleTb


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

//        var myScheduleEventRecyclerViewAdapter = MyScheduleRecyclerViewAdapter()
//        binding.myScheduleRv.adapter = myScheduleEventRecyclerViewAdapter

        var list = mutableListOf<MyScheduleEvent>()


        timeStr = intent.getStringExtra("timeStr")!!
        Log.d("TAG", "onCreate: $timeStr ")
        viewModel.getDetailScheduleList(
            detailScheduleRequest = DetailScheduleRequest(
                timeStr,
                "lhj"
            ), ::showToast
        )
//        if(viewModel.userDetailSchedule.value!!.isNotEmpty()){
//            for (i in 0 until viewModel.userDetailSchedule!!.value!!.size) {
//                list.add(MyScheduleEvent(viewModel.userDetailSchedule!!.value!![i].content, "123"))
//                myScheduleEventRecyclerViewAdapter.submitMyScheduleEventList(list)
//            }
//        }else{
//            Log.d("TAG", "onCreate:${viewModel.userDetailSchedule.value!![0]} ")
//        }

        /*  var array: List<DetailScheduleResponse>? =
          for(i in 0 until array!!.size){
              list.add(MyScheduleEvent(array[i].content,"123") )
          }
          */
/*
        myScheduleEventRecyclerViewAdapter.submitMyScheduleEventList(viewModel.userDetailSchedule.value.)

        viewModel.userDetailSchedule.observe(this, Observer {
*/
/*
        })*/

/*
                for (i in 0 until scheduleList.size) {
                    list.add(
                        MyScheduleEvent(
                            scheduleList[i].content,
                            "${scheduleList[i].startTime} ~ ${scheduleList[i].endTime}"

                        )
                    )
                    myScheduleEventRecyclerViewAdapter.submitMyScheduleEventList(list)
                }
                myScheduleEventRecyclerViewAdapter.submitMyScheduleEventList(list)
*/
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


}