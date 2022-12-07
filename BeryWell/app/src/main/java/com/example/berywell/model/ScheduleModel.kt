package com.example.berywell.model

import android.os.Parcel
import android.os.Parcelable

data class ScheduleModel(
    val content: String = "",
    val startTime: String = "",
    val endTime: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(content)
        parcel.writeString(startTime)
        parcel.writeString(endTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ScheduleModel> {
        override fun createFromParcel(parcel: Parcel): ScheduleModel {
            return ScheduleModel(parcel)
        }

        override fun newArray(size: Int): Array<ScheduleModel?> {
            return arrayOfNulls(size)
        }
    }
}