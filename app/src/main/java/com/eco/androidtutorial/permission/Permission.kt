package com.eco.androidtutorial.permission

interface Permission {
    fun request()
    fun isGranted(): Boolean
}