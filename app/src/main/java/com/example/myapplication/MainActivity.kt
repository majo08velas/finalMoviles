package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.ActorPrefs.Companion.prefs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        //val buttonUno: Button = findViewById(R.id.button)
        //val buttonDos: Button = findViewById(R.id.button2)
        val buttonProfileActor:Button = findViewById(R.id.buttonProfileActor)

        //val imageView: ImageView = findViewById(R.id.imageView)

        //val text: TextView = findViewById(R.id.cambiese)




        val actor1 = Actor("Matt", 12, R.drawable.matt)
        val actor2 = Actor("Jessica", 43,R.drawable.jessica )
        val character1 = Character("Mark","Watney", "Astronauta",actor1)
        val character2 = Character("Melissa","Lewis", "Astronauta",actor2)

        // Valor por Defecto
        var actor:Actor = Actor("Jessica", 43,R.drawable.jessica )

        /*buttonUno.setOnClickListener {
            text.text = "${character1.name} ${character1.lastName}"
            imageView.setImageResource(actor1.image)
            actor = actor1

        }

        buttonDos.setOnClickListener {
            text.text = "${character2.name} ${character2.lastName}"
            imageView.setImageResource(actor2.image)
            actor = actor2

        }*/

        buttonProfileActor.setOnClickListener {
            val i = Intent(this, ProfileActor::class.java)
            prefs.saveName("name",actor.fistName)
            prefs.saveImage("image",actor.image)
            startActivity(i)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_resource,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.home -> {
            Toast.makeText(this@MainActivity, "Inicio", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.info -> {
            Toast.makeText(this@MainActivity, "Info Desarrolladores", Toast.LENGTH_SHORT).show()
            val dialog = CustomAbout()
            dialog.show(supportFragmentManager, "Custom About Me")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}


