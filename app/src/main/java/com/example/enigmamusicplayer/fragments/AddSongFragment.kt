package com.example.enigmamusicplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.room.album.Song
import com.example.enigmamusicplayer.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*


/**
 * A simple [Fragment] subclass.
 * Use the [AddSongFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddSongFragment : Fragment() {

    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumId = arguments?.getInt("album_id") ?: 1
        buttonSubmitNewSong.setOnClickListener {
            val title = inputSongTitle.text.toString()
            val duration = inputSongDuration.text.toString()

            if (title == "" || duration == "") {
                return@setOnClickListener
            }

            albumViewModel.insertNewSong(
                Song(
                    song_title = title,
                    song_duration = duration,
                    song_album_id = albumId
                )
            )
            Navigation.findNavController(view).navigate(R.id.action_addSongFragment_pop)
        }
    }

}