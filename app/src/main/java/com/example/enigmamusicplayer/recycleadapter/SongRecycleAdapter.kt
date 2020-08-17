package com.example.enigmamusicplayer.recycleadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.viewmodel.Song
import com.squareup.picasso.Picasso

class SongRecycleAdapter (
    private val songList: List<Song>,
    private val getActivity: FragmentActivity?
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
        holder.songTitle.text = songList[position].title
        holder.artistName.text = songList[position].artist

        Picasso.with(getActivity).load(songList[position].imgUrl).into(holder.imageAlbum)
//        Picasso.get().load(songList[position].imgUrl).into(holder.imageAlbum)

        val bundle = Bundle()
            bundle.putInt("position", position)
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_songListFragment_to_songDetailsFragment, bundle)
        }
    }
}

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val songTitle = v.findViewById<TextView>(R.id.albumTittleTextView)
    val artistName = v.findViewById<TextView>(R.id.artistTextView)
    val imageAlbum: ImageView = v.findViewById(R.id.imageViewSong)
}