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

        val actor1 = Actor("Matt", "Damon", R.drawable.matt, "8 de octubre de 1970")
        val actor2 = Actor("Jessica", "Chastain",R.drawable.jessica, "24 de marzo de 1977" )
        val actor3 = Actor("Chiwetel ", "Ejiofor",R.drawable.chiwetel, "10 de julio de 1977" )
        val actor4 = Actor("Kate ", "Mara",R.drawable.kate, "27 de febrero de 1983" )
        val actor5 = Actor("Sebastian ", "Stan",R.drawable.sebastian, "13 de agosto de 1982" )
        val actor6 = Actor("Kristen ", "Wiig",R.drawable.kristen, "22 de agosto de 1973" )
        val actor7 = Actor("Sean ", "Bean",R.drawable.sean, "17 de abril de 1959" )
        val actor8 = Actor("Michael ", "Peña",R.drawable.michael, "13 de enero de 1976" )
        val actor9 = Actor("Aksel ", "Hennie",R.drawable.aksel, "29 de octubre de 1975" )
        val actor10 = Actor("Jeff ", "Daniels",R.drawable.jeff, "19 de febrero de 1955" )
        val actor11 = Actor("Donald ", "Glover",R.drawable.donald, "25 de septiembre de 1983" )
        val actor12 = Actor("Benedict ", "Wong",R.drawable.benedict, "3 de julio de 1971" )

        val character1 = Character("Mark","Watney", "Astronauta","Principal",actor1)
        val character2 = Character("Melissa","Lewis", "Astronauta","Principal",actor2)
        val character3 = Character("Venkat","Kapoor", "Astronauta","Secundario", actor3)

        btnMatt.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.matt)
            txtActorName.text = actor1.fistName + " " + actor1.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor2.bornDate
        }

        btnJessica.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.jessica)
            txtActorName.text = actor2.fistName + " " + actor2.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor1.bornDate
        }

        btnChiwetel.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.chiwetel)
            txtActorName.text = actor3.fistName + " " + actor3.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor3.bornDate
        }

        btnKate.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.kate)
            txtActorName.text = actor4.fistName + " " + actor4.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor4.bornDate
        }

        btnSebastian.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.sebastian)
            txtActorName.text = actor5.fistName + " " + actor5.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor5.bornDate
        }

        btnKristen.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.kristen)
            txtActorName.text = actor6.fistName + " " + actor6.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor6.bornDate
        }

        btnSean.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.sean)
            txtActorName.text = actor7.fistName + " " + actor7.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor7.bornDate
        }

        btnMichael.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.michael)
            txtActorName.text = actor8.fistName + " " + actor8.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor8.bornDate
        }

        btnAksel.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.aksel)
            txtActorName.text = actor9.fistName + " " + actor9.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor9.bornDate
        }

        btnJeff.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.jeff)
            txtActorName.text = actor10.fistName + " " + actor10.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor10.bornDate
        }

        btnDonald.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.donald)
            txtActorName.text = actor11.fistName + " " + actor11.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor11.bornDate
        }

        btnBenedict.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.benedict)
            txtActorName.text = actor12.fistName + " " + actor12.lastName
            txtActorBornDate.text = "Fecha de nacimiento: " + actor12.bornDate
        }



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
                saveImage(actor.image)
                saveDateBorn(actor.bornDate)
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
