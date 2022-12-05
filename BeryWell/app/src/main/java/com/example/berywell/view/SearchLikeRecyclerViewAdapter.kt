package com.example.berywell.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.berywell.R

class SearchLikeRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var searLikeList: List<SearchLikeEvent>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchLikeEventViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_search_like_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        searLikeList?.let { SearchLikeEvent ->
            (holder as SearchLikeEventViewHolder).bind(SearchLikeEvent[position])
        }
    }

    override fun getItemCount(): Int {
        return searLikeList!!.size
    }
    fun submitSearchLikeEventList(list: List<SearchLikeEvent>) {
        searLikeList = list
        notifyDataSetChanged()
    }
    class SearchLikeEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title : TextView = itemView.findViewById(R.id.user_schedule_title_tv)
        private val searchTime : TextView = itemView.findViewById(R.id.user_schedule_time_tv)

        fun bind(searchLikeEvent: SearchLikeEvent) {
            title.text = searchLikeEvent.title
            searchTime.text = searchLikeEvent.scheduleTime
        }
    }
}
