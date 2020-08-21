package com.example.enigmamusicplayer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.enigmamusicplayer.room.AppRoomDatabase
import com.example.enigmamusicplayer.room.album.Album
import com.example.enigmamusicplayer.room.album.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.enigmamusicplayer.room.album.Song

class AlbumViewModel(application: Application) : AndroidViewModel(application) {
    private val repository =
        AlbumRepository(AppRoomDatabase.getDatabaseInstance(application).albumDao())

    fun getAlbumWithSong() = repository.getAlbumWithSong()

    fun getAllAlbum() = repository.getAllAlbum()

    fun getAlbumWithId(id: Int) = repository.getAlbumWithId(id)

    fun createNewAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewAlbum(album)
        }
    }

    fun getSongWithAlbumId(id: Int) = repository.getSongWithAlbumId(id)

    fun insertNewSong(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNewSong(song)
        }
    }
}