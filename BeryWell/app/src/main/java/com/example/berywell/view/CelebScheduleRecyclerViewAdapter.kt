package com.example.berywell.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.berywell.R

class CelebScheduleRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var searLikeList: List<CelebScheduleEvent>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CelebScheduleEventViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_seleb_schedule_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        searLikeList?.let { SearchLikeEvent ->
            (holder as CelebScheduleEventViewHolder).bind(SearchLikeEvent[position])
        }
    }

    override fun getItemCount(): Int {
        return searLikeList!!.size
    }

    fun submitSelebScheduleEventList(list: List<CelebScheduleEvent>) {
        searLikeList = list
        notifyDataSetChanged()
    }

    class CelebScheduleEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name : TextView = itemView.findViewById(R.id.seleb_name_tv)
        private val job : TextView = itemView.findViewById(R.id.seleb_job_tv)

        fun bind(searchLikeEvent: CelebScheduleEvent) {
            name.text = searchLikeEvent.name
            job.text = searchLikeEvent.job
        }
    }
}