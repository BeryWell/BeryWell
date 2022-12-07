package com.example.berywell.network.data.response

data class DetailScheduleResponse(
    val id: String,
    val content: String,
    val startTime: String,
    val endTime: String,
    val user: String
)