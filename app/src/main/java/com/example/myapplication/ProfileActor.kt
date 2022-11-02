package com.example.myapplication


import android.annotation.SuppressLint
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

class ProfileActor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_actor)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val text: TextView = findViewById(R.id.actor_name_text)
        //val dateBorn: TextView = findViewById(R.id.actor_born_text)
        val imageView: ImageView = findViewById(R.id.imageView3)
        val btnActor = findViewById<Button>(R.id.buttonActor)

        btnActor.setOnClickListener{finish()}
        
        text.text = "${prefs.getFullName()}"
        //dateBorn.text = prefs.getDateBorn()
        imageView.setImageResource(prefs.getImage())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_resource,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.home -> {
            Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.info -> {
            Toast.makeText(this, "Info Desarrolladores", Toast.LENGTH_SHORT).show()
            val dialog = CustomAbout()
            dialog.show(supportFragmentManager, "Custom About Me")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}