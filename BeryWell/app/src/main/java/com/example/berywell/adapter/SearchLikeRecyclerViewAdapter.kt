package com.example.berywell.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.berywell.R
import com.example.berywell.model.SearchLikeModel

class SearchLikeRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var searchLikeModelList: List<SearchLikeModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchLikeViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_seleb_schedule_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        searchLikeModelList?.let { searchLikeModel ->
            (holder as SearchLikeViewHolder).bind(searchLikeModel[position])
        }
    }

    override fun getItemCount(): Int {
        return searchLikeModelList!!.size
    }
    fun searchLikeEventList(list: List<SearchLikeModel>) {
        searchLikeModelList = list
        notifyDataSetChanged()
    }
    class SearchLikeViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.seleb_name_tv)
        val job : TextView = itemView.findViewById(R.id.seleb_job_tv)
        val img : ImageView = itemView.findViewById(R.id.celeb_iv)
        fun bind(searchLikeModel: SearchLikeModel) {
            title.text = searchLikeModel.celebName
            job.text = searchLikeModel.celebJob
            img.setImageDrawable(searchLikeModel.img)
        }
    }
}