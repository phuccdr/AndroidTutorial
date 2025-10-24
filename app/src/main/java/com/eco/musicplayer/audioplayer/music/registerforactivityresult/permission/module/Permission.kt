package com.eco.musicplayer.audioplayer.music.registerforactivityresult.permission.module

interface Permission {
    fun request()
    fun isGranted(): Boolean
}