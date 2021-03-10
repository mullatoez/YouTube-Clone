package com.example.pone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {

    val videoTitles = listOf("First Title", "Second Title", "Third Title")

    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val videoTitle = videoTitles[position]
        val video = homeFeed.videos[position]
        holder.video_title.text = video.name
        holder.channel_name.text = video.channel.name
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val video_title: TextView = itemView.findViewById(R.id.video_title)

        val channel_name: TextView = itemView.findViewById(R.id.channel_name)
    }

}