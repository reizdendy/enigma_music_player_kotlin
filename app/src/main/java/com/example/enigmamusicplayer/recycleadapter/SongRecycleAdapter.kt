package com.example.enigmamusicplayer.recycleadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.room.album.Song

class SongRecycleAdapter (
    private val songList: List<Song>
) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_recycle_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = songList[position].song_title
        holder.songDuration.text = songList[position].song_duration
        holder.imgPlay.setOnClickListener {
            holder.imgPlay.setImageResource(R.drawable.ic_baseline_pause_24)
        }
    }
}

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val songTitle = v.findViewById<TextView>(R.id.songTitleRecycleTextView)
    val songDuration = v.findViewById<TextView>(R.id.durationRecycleTextView)
    val imgPlay: ImageView = v.findViewById(R.id.imgPlayRecycleView)
}