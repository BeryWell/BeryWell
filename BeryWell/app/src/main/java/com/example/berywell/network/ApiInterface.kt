package com.example.berywell.network

import com.example.berywell.network.data.response.BaseResponse
import com.example.berywell.network.data.response.ScheduleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //Post

    //Get
     @GET("/api/all")
     fun getAllSchedule(): Single<BaseResponse<List<ScheduleResponse>>>
}