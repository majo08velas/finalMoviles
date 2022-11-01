package com.example.myapplication

import android.app.Application
import com.example.myapplication.Prefs

class ActorPrefs: Application() {

        companion object{
            lateinit var prefs: Prefs
        }

        override fun onCreate() {
            super.onCreate()
            prefs = Prefs(applicationContext)
        }
    }