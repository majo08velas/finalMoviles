package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonUno: Button = findViewById(R.id.button)
        val buttonDos: Button = findViewById(R.id.button2)
        val buttonDesarrolladores: Button = findViewById(R.id.button3)

        val imageView: ImageView = findViewById(R.id.imageView)

        val text: TextView = findViewById(R.id.cambiese)

        val actor1 = Actor("Matt", 12, R.drawable.matt)
        val actor2 = Actor("Jessica", 43,R.drawable.jessica )

        buttonUno.setOnClickListener {
            text.text = actor1.name
            imageView.setImageResource(actor1.image)
        }

        buttonDos.setOnClickListener {
            text.text = actor2.name
            imageView.setImageResource(actor2.image)
        }

        buttonDesarrolladores.setOnClickListener {
            val dialog = CustomAbout()
            dialog.show(supportFragmentManager, "Custom About Me")
        }
    }
}