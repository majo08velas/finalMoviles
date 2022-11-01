package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.example.myapplication.ActorPrefs.Companion.prefs
import java.util.*


// Valor por Defecto
var actor = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08")

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val buttonUno: ImageButton = findViewById(R.id.button84)
        val buttonDos: Button = findViewById(R.id.button2)
        val buttonTres: Button = findViewById(R.id.buttonVenkat)
        val buttonProfileActor:Button = findViewById(R.id.button4)


        //val imageView: ImageView = findViewById(R.id.imageView)

        val actor1 = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08")
        val actor2 = Actor("Jessica", "Chastain",R.drawable.jessica, "1977-02-24" )
        val actor3 = Actor("Chiwetel ", "Ejiofor",R.drawable.chiwetel, "1977-06-10" )
        val character1 = Character("Mark","Watney", "Astronauta","Principal",actor1)
        val character2 = Character("Melissa","Lewis", "Astronauta","Principal",actor2)
        val character3 = Character("Venkat","Kapoor", "Astronauta","Secundario", actor3)

        setDataCharacter(buttonUno,character1,actor1)
        //setDataCharacter(buttonDos,character2,actor2)
        //setDataCharacter(buttonTres,character3,actor3)

        buttonProfileActor.setOnClickListener {
            val i = Intent(this, ProfileActor::class.java)
            prefs.run {
                saveFullName("${actor.fistName} ${actor.lastName}" )
                saveDateBorn(actor.bornDate)
                saveImage(actor.image)
                saveMovies(actor.movies)
            }
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

    }

    private fun setDataCharacter(btnCharacter:ImageButton, character: Character, actorAux: Actor){
        val imageView: ImageView = findViewById(R.id.imageView)
        val text: TextView = findViewById(R.id.cambiese)

        btnCharacter.setOnClickListener{
            text.text = "${character.name} ${character.lastName}"
            imageView.setImageResource(actorAux.image)
            val yearsOld = actorAux.showsAge()
            Log.d("Años", yearsOld)
            actor = actorAux
        }

    }

}



