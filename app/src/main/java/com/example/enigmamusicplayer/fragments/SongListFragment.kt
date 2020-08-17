package com.example.enigmamusicplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.recycleadapter.SongRecycleAdapter
import com.example.enigmamusicplayer.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_song_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [SongListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SongListFragment : Fragment() {

    private val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        songListRecycleView.layoutManager = LinearLayoutManager(activity)
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
            songListRecycleView.adapter = SongRecycleAdapter(it, activity)
        })

        addSongButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_songListFragment_to_addSongFragment)
        }
    }

}