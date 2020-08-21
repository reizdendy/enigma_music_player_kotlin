package com.example.enigmamusicplayer.room.album

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
class Album(
    @PrimaryKey(autoGenerate = true) val album_id: Int = 0,
    val album_title: String,
    val artist: String,
    val album_img_url: String
)

@Entity
class Song(
    @PrimaryKey(autoGenerate = true) val song_id: Int = 0,
    val song_album_id: Int,
    val song_title: String,
    val song_duration: String
)

data class AlbumWithSong(
    @Embedded val album: Album,
    @Relation(
        parentColumn = "album_id",
        entityColumn = "song_album_id"
    )
    val song: Song
)