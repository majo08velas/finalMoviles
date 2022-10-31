package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ActorPrefs.Companion.prefs
import java.util.*

// Valor por Defecto
var actor = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08")

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonUno: Button = findViewById(R.id.button)
        val buttonDos: Button = findViewById(R.id.button2)
        val buttonTres: Button = findViewById(R.id.buttonVenkat)
        val buttonProfileActor:Button = findViewById(R.id.button4)

        val buttonDesarrolladores: Button = findViewById(R.id.button3)

        val actor1 = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08")
        val actor2 = Actor("Jessica", "Chastain",R.drawable.jessica, "1977-02-24" )
        val actor3 = Actor("Chiwetel ", "Ejiofor",R.drawable.chiwetel, "1977-06-10" )
        val character1 = Character("Mark","Watney", "Astronauta","Principal",actor1)
        val character2 = Character("Melissa","Lewis", "Astronauta","Principal",actor2)
        val character3 = Character("Venkat","Kapoor", "Astronauta","Secundario", actor3)

        setDataCharacter(buttonUno,character1,actor1)
        setDataCharacter(buttonDos,character2,actor2)
        setDataCharacter(buttonTres,character3,actor3)


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

        buttonDesarrolladores.setOnClickListener {
            val dialog = CustomAbout()
            dialog.show(supportFragmentManager, "Custom About Me")
        }
    }

    private fun setDataCharacter(btnCharacter:Button, character: Character, actorAux: Actor){
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



