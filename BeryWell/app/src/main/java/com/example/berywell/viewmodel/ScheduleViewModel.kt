package com.example.berywell.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.berywell.network.ApiClient
import com.example.berywell.network.data.request.DetailScheduleRequest
import com.example.berywell.network.data.request.ScheduleRequest
import com.example.berywell.network.data.response.BaseResponse
import com.example.berywell.network.data.response.DetailScheduleResponse
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

    private var _userDetailSchedule = MutableLiveData<List<DetailScheduleResponse>>()
    val userDetailSchedule: LiveData<List<DetailScheduleResponse>>
        get() = _userDetailSchedule

    private var _titleStr = MutableLiveData<String>()

    @SuppressLint("CheckResult")
    fun getAllScheduleList(showToast: (msg: String) -> Unit) {
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

    @SuppressLint("CheckResult")
    fun sendScheduleList(scheduleRequest: ScheduleRequest, showToast: (msg: String) -> Unit) {
        scheduleRepository.sendSchedule(scheduleRequest).subscribeBy(
            onSuccess = {
                showToast("성공했습니다.")
            },
            onError = {
                Log.d("TAG", "sendScheduleList: ${scheduleRequest.title} ")
                Log.d("TAG", "sendScheduleList: ${scheduleRequest.schedules} ")
                Log.d("TAG", "sendScheduleList: ${scheduleRequest.userName} ")
                Log.d("lhj", "error")
                it.printStackTrace()
            }
        )
    }

    fun updateTitleStr(str: String){
        _titleStr.value = str
    }

    @SuppressLint("CheckResult")
    fun getDetailScheduleList(detailScheduleRequest: DetailScheduleRequest, showToast: (msg: String) -> Unit){
        scheduleRepository.getDetailSchedule(detailScheduleRequest).subscribeBy(
            onSuccess = {
                if (it.success) {
                    showToast("성공했습니다.")
                    _userDetailSchedule.value = it.data!!
                    Log.d("TAG", "getDetailScheduleList: ${userDetailSchedule.value!![0]}")

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