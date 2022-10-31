package com.example.myapplication


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
        val imageView: ImageView = findViewById(R.id.imageView3)


        text.text = prefs.getName()
        imageView.setImageResource(prefs.getImage())

    }
}