package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.ActorPrefs.Companion.prefs

// Valor por Defecto
var actor = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        //val buttonUno: Button = findViewById(R.id.button)
        //val buttonDos: Button = findViewById(R.id.button2)
        //val text: TextView = findViewById(R.id.cambiese)
        val buttonProfileActor:Button = findViewById(R.id.buttonProfileActor)
        val imageView: ImageView = findViewById(R.id.imageView)

        val btnJessica = findViewById<ImageButton>(R.id.ibutton1)
        val btnMatt = findViewById<ImageButton>(R.id.ibutton2)
        val btnChiwetel = findViewById<ImageButton>(R.id.ibutton3)
        val btnKate = findViewById<ImageButton>(R.id.ibutton4)
        val btnSebastian = findViewById<ImageButton>(R.id.ibutton5)
        val btnKristen = findViewById<ImageButton>(R.id.ibutton6)
        val btnMichael = findViewById<ImageButton>(R.id.ibutton7)
        val btnSean = findViewById<ImageButton>(R.id.ibutton8)
        val btnAksel = findViewById<ImageButton>(R.id.ibutton9)
        val btnJeff = findViewById<ImageButton>(R.id.ibutton10)
        val btnDonald = findViewById<ImageButton>(R.id.ibutton11)
        val btnBenedict = findViewById<ImageButton>(R.id.ibutton12)

        val txtActorName = findViewById<TextView>(R.id.actorName)
        val txtActorBornDate = findViewById<TextView>(R.id.actorBornDate)
        val txtActorAwards = findViewById<TextView>(R.id.actorAwards)
        val txtActorMovies = findViewById<TextView>(R.id.actorMovies)

        btnJessica.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.jessica)
            txtActorName.text = "Jessica Chastain"
            txtActorBornDate.text = "24 de marzo de 1977"
        }

        btnMatt.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.matt)
            txtActorName.text = "Matt Damon"
        }
        btnChiwetel.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.chiwetel)
            txtActorName.text = "Chiwetel Ejiofor"
        }

        btnKate.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.kate)
            txtActorName.text = "Kate Mara"
        }

        btnSebastian.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.sebastian)
            txtActorName.text = "Sebastian Stan"
        }

        btnKristen.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.kristen)
            txtActorName.text = "Kristen Wiig"
        }

        btnSean.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.sean)
            txtActorName.text = "Sean Bean"
        }

        btnMichael.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.michael)
            txtActorName.text = "Michael Peña"
        }

        btnAksel.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.aksel)
            txtActorName.text = "Aksel Hennie"
        }

        btnJeff.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.jeff)
            txtActorName.text = "Jeff Daniels"
        }

        btnDonald.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.donald)
            txtActorName.text = "Donald Glover"
        }

        btnBenedict.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.benedict)
            txtActorName.text = "Benedict Wong"
        }





        val actor1 = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08")
        val actor2 = Actor("Jessica", "Chastain",R.drawable.jessica, "1977-02-24" )
        val actor3 = Actor("Chiwetel ", "Ejiofor",R.drawable.chiwetel, "1977-06-10" )
        val character1 = Character("Mark","Watney", "Astronauta","Principal",actor1)
        val character2 = Character("Melissa","Lewis", "Astronauta","Principal",actor2)
        val character3 = Character("Venkat","Kapoor", "Astronauta","Secundario", actor3)


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
        else -> super.onOptionsItemSelected(item)
    }

}
