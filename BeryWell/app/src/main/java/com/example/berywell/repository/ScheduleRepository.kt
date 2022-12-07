package com.example.berywell.repository

import com.example.berywell.network.ApiClient
import com.example.berywell.network.data.request.DetailScheduleRequest
import com.example.berywell.network.data.request.ScheduleRequest
import com.example.berywell.network.data.response.BaseResponse
import com.example.berywell.network.data.response.DetailScheduleResponse
import com.example.berywell.network.data.response.ScheduleResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.http.Body

interface ScheduleRepository {
    fun getAllSchedule(): Single<BaseResponse<List<ScheduleResponse>>>
    fun sendSchedule(scheduleRequest: ScheduleRequest): Single<BaseResponse<ScheduleRequest>>
    fun getDetailSchedule(dedatilScheduleRequset: DetailScheduleRequest): Single<BaseResponse<List<DetailScheduleResponse>>>
}

class ScheduleRepositoryImpl : ScheduleRepository{
    override fun getAllSchedule(): Single<BaseResponse<List<ScheduleResponse>>> {
        return ApiClient.api.getAllSchedule().subscribeOn(Schedulers.computation()).observeOn(
            AndroidSchedulers.mainThread()).map { it }
    }

    override fun sendSchedule(scheduleRequest: ScheduleRequest): Single<BaseResponse<ScheduleRequest>> {
        return ApiClient.api.sendSchedule(scheduleRequest).subscribeOn(Schedulers.computation()).observeOn(
            AndroidSchedulers.mainThread()).map { it }
    }

    override fun getDetailSchedule(dedatilScheduleRequset: DetailScheduleRequest): Single<BaseResponse<List<DetailScheduleResponse>>>{
        return ApiClient.api.getDetailSchedule(dedatilScheduleRequset).subscribeOn(Schedulers.computation()).observeOn(
            AndroidSchedulers.mainThread()).map { it }
    }
}