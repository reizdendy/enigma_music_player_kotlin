package com.example.enigmamusicplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.recycleadapter.SongRecycleAdapter
import com.example.enigmamusicplayer.viewmodel.AlbumViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_detail.*

/**
 * A simple [Fragment] subclass.
 * Use the [AlbumDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlbumDetailFragment : Fragment() {

    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumId = arguments?.getInt("album_id") ?: 1

        albumViewModel.getAlbumWithId(albumId).observe(viewLifecycleOwner, Observer {
            albumTitleDetail.text = it.album_title
            Picasso.with(activity).load(it.album_img_url).into(imageViewAlbumDetail)
        })

        songDetailRecycleView.layoutManager = LinearLayoutManager(activity)
        albumViewModel.getSongWithAlbumId(albumId).observe(viewLifecycleOwner, Observer {
            songDetailRecycleView.adapter = SongRecycleAdapter(it)
        })

        addSongButton.setOnClickListener {
            val bundle = bundleOf(Pair("album_id", albumId))
            Navigation.findNavController(it)
                .navigate(R.id.action_albumDetailFragment_to_addSongFragment, bundle)
        }
    }

}