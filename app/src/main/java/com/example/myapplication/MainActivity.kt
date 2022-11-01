package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.ActorPrefs.Companion.prefs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonUno: Button = findViewById(R.id.button)
        val buttonDos: Button = findViewById(R.id.button2)
        val buttonProfileActor:Button = findViewById(R.id.button4)

        val buttonDesarrolladores: Button = findViewById(R.id.button3)

        val imageView: ImageView = findViewById(R.id.imageView)

        val text: TextView = findViewById(R.id.cambiese)




        val actor1 = Actor("Matt", 12, R.drawable.matt)
        val actor2 = Actor("Jessica", 43,R.drawable.jessica )
        val character1 = Character("Mark","Watney", "Astronauta",actor1)
        val character2 = Character("Melissa","Lewis", "Astronauta",actor2)

        // Valor por Defecto
        var actor:Actor = Actor("Jessica", 43,R.drawable.jessica )

        buttonUno.setOnClickListener {
            text.text = "${character1.name} ${character1.lastName}"
            imageView.setImageResource(actor1.image)
            actor = actor1

        }

        buttonDos.setOnClickListener {
            text.text = "${character2.name} ${character2.lastName}"
            imageView.setImageResource(actor2.image)
            actor = actor2

        }

        buttonProfileActor.setOnClickListener {
            val i = Intent(this, ProfileActor::class.java)
            prefs.saveName("name",actor.fistName)
            prefs.saveImage("image",actor.image)
            startActivity(i)
        }

        buttonDesarrolladores.setOnClickListener {
            val dialog = CustomAbout()
            dialog.show(supportFragmentManager, "Custom About Me")
        }

    }
}


