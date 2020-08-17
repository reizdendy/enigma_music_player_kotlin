package com.example.enigmamusicplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.viewmodel.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_song_details.*

/**
 * A simple [Fragment] subclass.
 * Use the [SongDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SongDetailsFragment : Fragment() {

    private val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt("position") ?: 0
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
//            artistNameSongDetail.text = it[position].artist
            albumNameSongDetail.text = it[position].title
            Picasso.with(activity).load(it[position].imgUrl).into(imageViewSongDetail)
        })
    }

}