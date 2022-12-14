package com.example.berywell.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.berywell.R
import com.example.berywell.model.SearchLikeModel

class CelebScheduleRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var searLikeList: List<SearchLikeModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CelebScheduleEventViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_seleb_schedule_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        searLikeList?.let { SearchLikeEvent ->
            (holder as CelebScheduleEventViewHolder).bind(SearchLikeEvent[position])
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, SearchLikeActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return searLikeList!!.size
    }

    fun submitSelebScheduleEventList(list: List<SearchLikeModel>) {
        searLikeList = list
        notifyDataSetChanged()
    }

    class CelebScheduleEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name : TextView = itemView.findViewById(R.id.seleb_name_tv)
        private val job : TextView = itemView.findViewById(R.id.seleb_job_tv)
        private val img : ImageView = itemView.findViewById(R.id.celeb_iv)

        fun bind(searchLikeEvent: SearchLikeModel) {
            name.text = searchLikeEvent.celebName
            job.text = searchLikeEvent.celebJob
            img.setImageDrawable(searchLikeEvent.img)

        }
    }
}