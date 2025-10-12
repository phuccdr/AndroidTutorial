package com.eco.androidtutorial.registerforactivityresult.permission.module

interface Permission {
    fun request()
    fun isGranted(): Boolean
}