package com.example.enigmamusicplayer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel :ViewModel(){
    var songList = mutableListOf<Song>()
    var songLiveData = MutableLiveData<List<Song>>()

    init {
        songList.add(Song("Ingin Lekas Memelukmu Lagi", "D'masiv feat Pusakata","https://i.ytimg.com/vi/kaneyG80ALI/maxresdefault.jpg"))
        songList.add(Song("Send Melagu", "Bara Suara", "https://elrhamdan9.files.wordpress.com/2016/03/barasuara-image.jpg?w=1200"))
        songList.add(Song("Berdistraksi", "Danilla", "https://lh3.googleusercontent.com/proxy/DK1mSHLQUIxcg7BNyYWur7hqElogge50vKTY7_tEeCEStatyLIcHC6PjufwT4TUGpVGDkQk0KTi75K8vV9JGOogOtsVLRiTih4pYAq64jgi_gXMNt6Zmfok6FmfYH0i-ueSbOnw1ITcAzAq3ocoJHw"))
        songList.add(Song("Padi Milik Rakyat", ".feast", "https://4.bp.blogspot.com/-4v-dVDkHRv8/W6_Dn25-iBI/AAAAAAAAUBY/SZUGKt_acqk9M2m0f7-rDCXAPSsXdvYFwCLcBGAs/s1600/.Feast%2B-%2BBeberapa%2BOrang%2BMemaafkan.jpg"))
        songList.add(Song("Nematomorpha", "Fourtwenty", "https://cdn2.tstatic.net/tribunnewswiki/foto/bank/images/fourtwnty1.jpg"))
        songLiveData.value = songList
    }

    fun addSong(newSong: Song){
        songList.add(newSong)
        songLiveData.value = songList
    }

    fun getSongs() = songLiveData as LiveData<List<Song>>
}