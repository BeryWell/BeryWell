package com.example.berywell.network

import com.example.berywell.network.data.request.DetailScheduleRequest
import com.example.berywell.network.data.request.ScheduleRequest
import com.example.berywell.network.data.response.BaseResponse
import com.example.berywell.network.data.response.DetailScheduleResponse
import com.example.berywell.network.data.response.ScheduleResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    //Post
    @POST("/api/create")
    fun sendSchedule(@Body scheduleRequest: ScheduleRequest): Single<BaseResponse<ScheduleRequest>>

    @POST("/api/schedule-detail")
    fun getDetailSchedule(@Body dedatilScheduleRequset: DetailScheduleRequest): Single<BaseResponse<List<DetailScheduleResponse>>>

    //Get
     @GET("/api/all")
     fun getAllSchedule(): Single<BaseResponse<List<ScheduleResponse>>>
}