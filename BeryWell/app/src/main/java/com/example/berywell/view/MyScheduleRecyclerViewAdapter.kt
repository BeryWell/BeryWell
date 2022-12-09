package com.example.berywell.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.berywell.R

class MyScheduleRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var myScheduleEvent: List<MyScheduleEvent>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CelebScheduleEventViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_my_schedule_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        myScheduleEvent?.let { MyScheduleEvent ->
            (holder as CelebScheduleEventViewHolder).bind(MyScheduleEvent[position])
        }
    }

    override fun getItemCount(): Int {
        return if(myScheduleEvent!!.isEmpty())
            0
        else
            myScheduleEvent!!.size
    }

    fun submitMyScheduleEventList(list: List<MyScheduleEvent>) {
        myScheduleEvent = list
        notifyDataSetChanged()
    }

    class CelebScheduleEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title : TextView = itemView.findViewById(R.id.my_schedule_title_tv)
        private val time : TextView = itemView.findViewById(R.id.my_schedule_time_tv)

        fun bind(searchLikeEvent: MyScheduleEvent) {
            title.text = searchLikeEvent.title
            time.text = searchLikeEvent.time
        }
    }
}