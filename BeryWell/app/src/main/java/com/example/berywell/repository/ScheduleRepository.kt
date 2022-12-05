package com.example.berywell.repository

import com.example.berywell.network.ApiClient
import com.example.berywell.network.data.response.BaseResponse
import com.example.berywell.network.data.response.ScheduleResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface ScheduleRepository {
    fun getAllSchedule(): Single<BaseResponse<List<ScheduleResponse>>>
}

class ScheduleRepositoryImpl : ScheduleRepository{
    override fun getAllSchedule(): Single<BaseResponse<List<ScheduleResponse>>> {
        return ApiClient.api.getAllSchedule().subscribeOn(Schedulers.computation()).observeOn(
            AndroidSchedulers.mainThread()).map { it }
    }
}