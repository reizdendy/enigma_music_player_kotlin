package com.example.enigmamusicplayer.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.enigmamusicplayer.room.album.Album
import com.example.enigmamusicplayer.room.album.AlbumDao
import com.example.enigmamusicplayer.room.album.Song

@Database(entities = [Album::class, Song::class], version = 3)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao

    companion object {
        private var DATABASE_INSTANCE: AppRoomDatabase? = null

        fun getDatabaseInstance(context: Context): AppRoomDatabase {
            if (DATABASE_INSTANCE != null) DATABASE_INSTANCE as AppRoomDatabase

            DATABASE_INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "song_db"
            ).fallbackToDestructiveMigration().build()

            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}