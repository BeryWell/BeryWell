package com.example.berywell.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.berywell.network.data.response.ScheduleResponse
import com.example.berywell.repository.ScheduleRepository
import com.example.berywell.repository.ScheduleRepositoryImpl
import io.reactivex.rxkotlin.subscribeBy
import kotlin.math.log

class ScheduleViewModel : ViewModel() {
    private val scheduleRepository = ScheduleRepositoryImpl()

    private var _allSchedule = MutableLiveData<List<ScheduleResponse>>()
    val allSchedule: LiveData<List<ScheduleResponse>>
        get() = _allSchedule

    @SuppressLint("CheckResult")
    fun getAllScheduleList(showToast: (msg: String) -> Unit){
        scheduleRepository.getAllSchedule().subscribeBy(
            onSuccess = {
                _allSchedule.value = it.data!!

                Log.d("lhj", "${_allSchedule.value}")
                if (it.success) {
                    showToast("성공했습니다.")
                } else {
                    showToast("실패 : ${it.msg}")
                }
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}