package com.example.pone

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

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
        holder.channel_name.text = video.channel.name + " : " + "20K Views\n4 days ago"

        val thumbnailImageView = holder.thumb_nail
        Picasso.with(holder.itemView.context).load(video.imageUrl).into(
            thumbnailImageView
        )

        val channelImageView = holder.channel_image
        Picasso.with(holder.itemView.context).load(video.channel.profileImageUrl).into(
            channelImageView
        )
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val video_title: TextView = itemView.findViewById(R.id.video_title)

        val channel_name: TextView = itemView.findViewById(R.id.channel_name)

        val thumb_nail: ImageView = itemView.findViewById(R.id.video_thumbnail)

        val channel_image: ImageView = itemView.findViewById(R.id.channel_image)

        init {
            itemView.setOnClickListener {

                val intent = Intent(itemView.context, CourseDetailActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

}