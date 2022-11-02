package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.ActorPrefs.Companion.prefs
import java.util.*


// Valor por Defecto
var actor = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08")
var rb1: RadioButton ?= null
var rb2: RadioButton ?= null
var rb3: RadioButton ?= null
var rb4: RadioButton ?= null
var rg1: RadioGroup ?= null

class MainActivity : AppCompatActivity() {

    private lateinit var txtBorn: TextView
    private lateinit var txtAwards: TextView
    private lateinit var txtMovies: TextView
    private lateinit var changeLan: TextView
    private lateinit var buttonProfileActor: Button
    lateinit var lang: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        //val buttonUno: Button = findViewById(R.id.button)
        //val buttonDos: Button = findViewById(R.id.button2)
        //val text: TextView = findViewById(R.id.cambiese)
        buttonProfileActor = findViewById(R.id.buttonProfileActor)
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

        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4 = findViewById(R.id.rb4)
        rg1 = findViewById(R.id.rg1)

        txtBorn = findViewById(R.id.born_text)
        txtAwards = findViewById(R.id.award_text)
        txtMovies = findViewById(R.id.movies_text)
        changeLan = findViewById(R.id.changeLan)

        /*rb1?.setOnCheckedChangeListener{

            rb2?.setEnabled(false)
            rb3?.setEnabled(false)
            rb4?.setEnabled(false)
            rb1?.setBackgroundColor(R.color.purple_200)
        }*/

        rb1?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (isChecked) {
                    rb2?.setChecked(false)
                    rb3?.setChecked(false)
                    rb4?.setChecked(false)
                    lang = "es"
                    updateResource(lang)
                }
            }
        })

        rb2?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (isChecked) {
                    rb1?.setChecked(false)
                    rb3?.setChecked(false)
                    rb4?.setChecked(false)
                    lang = "en"
                    updateResource(lang)
                }
            }
        })

        rb3?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (isChecked) {
                    rb2?.setChecked(false)
                    rb1?.setChecked(false)
                    rb4?.setChecked(false)
                    lang = "pt"
                    updateResource(lang)
                }
            }
        })

        rb4?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (isChecked) {
                    rb2?.setChecked(false)
                    rb1?.setChecked(false)
                    rb3?.setChecked(false)
                    lang = "ja"
                    updateResource(lang)
                }
            }
        })

        val actor1 = Actor("Matt", "Damon", R.drawable.matt, "1970-10-08")
        val actor2 = Actor("Jessica", "Chastain",R.drawable.jessica, "1977-03-24" )
        val actor3 = Actor("Chiwetel ", "Ejiofor",R.drawable.chiwetel, "1977-07-10" )
        val actor4 = Actor("Kate ", "Mara",R.drawable.kate, "1983-02-27" )
        val actor5 = Actor("Sebastian ", "Stan",R.drawable.sebastian, "1982-08-16" )
        val actor6 = Actor("Kristen ", "Wiig",R.drawable.kristen, "1973-08-22" )
        val actor7 = Actor("Sean ", "Bean",R.drawable.sean, "1959-04-27" )
        val actor8 = Actor("Michael ", "Peña",R.drawable.michael, "1976-01-13" )
        val actor9 = Actor("Aksel ", "Hennie",R.drawable.aksel, "1975-10-29" )
        val actor10 = Actor("Jeff ", "Daniels",R.drawable.jeff, "1955-02-19" )
        val actor11 = Actor("Donald ", "Glover",R.drawable.donald, "1983-09-25" )
        val actor12 = Actor("Benedict ", "Wong",R.drawable.benedict, "1971-07-03" )

        val character1 = Character("Mark","Watney", "Astronauta","Principal",actor1)
        val character2 = Character("Melissa","Lewis", "Astronauta","Principal",actor2)
        val character3 = Character("Venkat","Kapoor", "Astronauta","Secundario", actor3)

        btnMatt.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.matt)
            txtActorName.text = actor1.fistName + " " + actor1.lastName
            txtActorBornDate.text = " " + actor2.bornDate
        }

        btnJessica.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.jessica)
            txtActorName.text = actor2.fistName + " " + actor2.lastName
            txtActorBornDate.text = " " + actor1.bornDate
        }

        btnChiwetel.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.chiwetel)
            txtActorName.text = actor3.fistName + " " + actor3.lastName
            txtActorBornDate.text = " " + actor3.bornDate
        }

        btnKate.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.kate)
            txtActorName.text = actor4.fistName + " " + actor4.lastName
            txtActorBornDate.text = " " + actor4.bornDate
        }

        btnSebastian.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.sebastian)
            txtActorName.text = actor5.fistName + " " + actor5.lastName
            txtActorBornDate.text = " " + actor5.bornDate
        }

        btnKristen.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.kristen)
            txtActorName.text = actor6.fistName + " " + actor6.lastName
            txtActorBornDate.text = " " + actor6.bornDate
        }

        btnSean.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.sean)
            txtActorName.text = actor7.fistName + " " + actor7.lastName
            txtActorBornDate.text = " " + actor7.bornDate
        }

        btnMichael.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.michael)
            txtActorName.text = actor8.fistName + " " + actor8.lastName
            txtActorBornDate.text = " " + actor8.bornDate
        }

        btnAksel.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.aksel)
            txtActorName.text = actor9.fistName + " " + actor9.lastName
            txtActorBornDate.text = " " + actor9.bornDate
        }

        btnJeff.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.jeff)
            txtActorName.text = actor10.fistName + " " + actor10.lastName
            txtActorBornDate.text = " " + actor10.bornDate
        }

        btnDonald.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.donald)
            txtActorName.text = actor11.fistName + " " + actor11.lastName
            txtActorBornDate.text = " " + actor11.bornDate
        }

        btnBenedict.setOnClickListener{
            imageView.setBackgroundResource(R.drawable.benedict)
            txtActorName.text = actor12.fistName + " " + actor12.lastName
            txtActorBornDate.text = " " + actor12.bornDate
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
            i.putExtra("LANG",lang)
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

    fun updateResource(idioma:String){
        val recursos = resources
        val displayMetrics = recursos.displayMetrics
        val configuracion = resources.configuration

        configuracion.setLocale(Locale(idioma))
        recursos.updateConfiguration(configuracion, displayMetrics)
        configuracion.locale = Locale(idioma)
        resources.updateConfiguration(configuracion, displayMetrics)

        rb1?.text = recursos.getString(R.string.es_text)
        rb2?.text = recursos.getString(R.string.en_text)
        rb3?.text = recursos.getString(R.string.pt_text)
        rb4?.text = recursos.getString(R.string.jp_text)
        txtBorn.text = recursos.getString(R.string.born_txt)
        txtAwards.text = recursos.getString(R.string.awards_text)
        txtMovies.text = recursos.getString(R.string.movies_text)
        changeLan.text = recursos.getString(R.string.changeLang)
        buttonProfileActor.text = recursos.getString(R.string.btn_character)

    }


}