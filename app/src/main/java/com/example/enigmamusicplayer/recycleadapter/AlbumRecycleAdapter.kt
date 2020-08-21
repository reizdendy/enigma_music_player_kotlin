package com.example.enigmamusicplayer.recycleadapter

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
import com.example.enigmamusicplayer.room.album.Album
import com.squareup.picasso.Picasso

class AlbumRecycleAdapter(
    private val albumList: List<Album>,
    private val getActivity: FragmentActivity?
) : RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_recycle_layout, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.albumTitle.text = albumList[position].album_title
        holder.artistName.text = albumList[position].artist
        Picasso.with(getActivity).load(albumList[position].album_img_url).into(holder.albumImage)

        val bundle = bundleOf(Pair("album_id", albumList[position].album_id))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_albumListFragment_to_albumDetailFragment, bundle)
        }
    }
}

class AlbumViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val albumTitle = v.findViewById<TextView>(R.id.albumTitleRecycleTextView)
    val artistName = v.findViewById<TextView>(R.id.artistRecycleTextView)
    val albumImage: ImageView = v.findViewById(R.id.imageAlbumRecycleView)
}