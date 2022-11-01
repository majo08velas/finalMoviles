package com.example.myapplication


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.ActorPrefs.Companion.prefs

class ProfileActor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_actor)

        val text: TextView = findViewById(R.id.actor_name_text)
        //val dateBorn: TextView = findViewById(R.id.actor_born_text)
        val imageView: ImageView = findViewById(R.id.imageView3)

        text.text = "${prefs.getFullName()}"
        //dateBorn.text = prefs.getDateBorn()
        imageView.setImageResource(prefs.getImage())

    }
}