package com.example.enigmamusicplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.room.album.Album
import com.example.enigmamusicplayer.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_add_album.*

/**
 * A simple [Fragment] subclass.
 * Use the [AddAlbumFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddAlbumFragment : Fragment() {
    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSubmitNewAlbum.setOnClickListener {
            val title = inputAlbumName.text.toString()
            val artist = inputArtistName.text.toString()
            val imageUrl = inputImageUrl.text.toString()

            if (title == "" || artist == "" || imageUrl == "" ){
                return@setOnClickListener
            }

            val newAlbum = Album(album_title = title,artist =  artist,album_img_url =  imageUrl)
            albumViewModel.createNewAlbum(newAlbum)

            Navigation.findNavController(view).navigate(R.id.action_addAlbumFragment_pop)
        }
    }

}