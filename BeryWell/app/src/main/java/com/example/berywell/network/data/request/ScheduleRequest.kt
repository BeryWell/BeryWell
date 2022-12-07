package com.example.berywell.network.data.request

import com.example.berywell.model.ScheduleModel
import com.example.berywell.model.ScheduleResult

data class ScheduleRequest(
    val title: String,
    val userName: String,
    val schedules: List<ScheduleResult>
)