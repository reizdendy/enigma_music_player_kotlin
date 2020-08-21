package com.example.enigmamusicplayer.room.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao {
    @Transaction
    @Query("SELECT * FROM Album")
    fun getAlbumWithSong(): LiveData<List<AlbumWithSong>>

    @Query("SELECT * FROM Album")
    fun getAllAlbum(): LiveData<List<Album>>

    @Query(value = "SELECT * FROM Album WHERE album_id = :id")
    fun getAlbumWithId(id:Int): LiveData<Album>

    @Insert
    fun createNewAlbum(album: Album)

    @Query(value = "SELECT * FROM Song WHERE song_album_id = :id")
    fun getSongWithAlbumId(id:Int): LiveData<List<Song>>

    @Insert
    fun insertNewSong(song: Song)
}