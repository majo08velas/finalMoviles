package com.example.myapplication

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.ImageView.ScaleType
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.ActorPrefs.Companion.prefs
import java.util.*


// Valor por Defecto
var actor = Actor("Matt", "Damon", R.drawable.matt, "1970-09-08", "mattdamonteam", arrayOf(), arrayOf())
var character = Character("Mark","Watney", "Astronauta","Principal","",actor,R.drawable.matt,7)
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
    private lateinit var lang: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        buttonProfileActor = findViewById(R.id.buttonProfileActor)


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


        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4 = findViewById(R.id.rb4)
        rg1 = findViewById(R.id.rg1)

        txtBorn = findViewById(R.id.born_text)
        txtAwards = findViewById(R.id.award_text)
        txtMovies = findViewById(R.id.movies_text)
        changeLan = findViewById(R.id.changeLan)

        rb2?.isChecked = true
        lang = "en"

        rb1?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                rb2?.isChecked = false
                rb3?.isChecked = false
                rb4?.isChecked = false
                lang = "es"
                updateResource(lang)
                restartApplication()
            }
        }

        rb2?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                rb1?.isChecked = false
                rb3?.isChecked = false
                rb4?.isChecked = false
                lang = "en"
                updateResource(lang)
                restartApplication()
            }
        }

        rb3?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                rb2?.isChecked = false
                rb1?.isChecked = false
                rb4?.isChecked = false
                lang = "pt"
                updateResource(lang)
                restartApplication()
            }
        }

        rb4?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                rb2?.isChecked = false
                rb1?.isChecked = false
                rb3?.isChecked = false
                lang = "ja"
                updateResource(lang)
                restartApplication()
            }
        }

        val weekDays = arrayOf(R.raw.m_matt_movie_1,R.raw.m_matt_movie_2,R.raw.m_matt_movie_3,R.raw.m_matt_movie_4,R.raw.m_matt_movie_5 )
        val moviesJessica = arrayOf(R.raw.m_jessica_1,R.raw.m_jessica_2,R.raw.m_jessica_3,R.raw.m_jessica_4,R.raw.m_jessica_5 )
        val moviesChiwetel = arrayOf(R.raw.m_chiwetel_1,R.raw.m_chiwetel_2,R.raw.m_chiwetel_3,R.raw.m_chiwetel_4,R.raw.m_chiwetel_5)
        val moviesKate = arrayOf(R.raw.m_kate_1,R.raw.m_kate_2,R.raw.m_kate_3,R.raw.m_kate_4,R.raw.m_kate_5)
        val moviesSebastian = arrayOf(R.raw.m_sebastian_1,R.raw.m_sebastian_2,R.raw.m_sebastian_3,R.raw.m_sebastian_4,R.raw.m_sebastian_5)
        val moviesKristen = arrayOf(R.raw.m_kristen_1,R.raw.m_kristen_2,R.raw.m_kristen_3,R.raw.m_kristen_4,R.raw.m_kristen_5)
        val moviesSean = arrayOf(R.raw.m_sean_1,R.raw.m_sean_2,R.raw.m_sean_3,R.raw.m_sean_4,R.raw.m_sean_5)
        val moviesMichael = arrayOf(R.raw.m_michael_1,R.raw.m_michael_2,R.raw.m_michael_3,R.raw.m_michael_4,R.raw.m_michael_5)
        val moviesAksel = arrayOf(R.raw.m_aksel_1,R.raw.m_aksel_2,R.raw.m_aksel_3,R.raw.m_aksel_4,R.raw.m_aksel_5)
        val moviesJeff = arrayOf(R.raw.m_jeff_1,R.raw.m_jeff_4,R.raw.m_jeff_5,R.raw.m_jeff_2,R.raw.m_jeff_3)
        val moviesDonald = arrayOf(R.raw.m_donald_1,R.raw.m_donald_2,R.raw.m_donald_3,R.raw.m_donald_4,R.raw.m_donald_5)
        val moviesBenedict = arrayOf(R.raw.m_benedict_1,R.raw.m_benedict_2,R.raw.m_benedict_3,R.raw.m_benedict_4,R.raw.m_benedict_5)

        val mattAwards = arrayOf(R.raw.oscar,R.raw.critics,R.raw.people,R.raw.golden,R.raw.mtv )
        val jessicaAwards = arrayOf(R.raw.oscar,R.raw.golden,R.raw.critics,R.raw.satellite,R.raw.sag)
        val chiwetelAwards = arrayOf(R.raw.indpendent,R.raw.bafta,R.raw.nigeria,R.raw.britain,R.raw.aacta)
        val kateAwards = arrayOf(R.raw.cinemacon, 0,0,0,0)
        val sebastianAwards = arrayOf(R.raw.mtv,0,0,0,0)
        val kristenAwards = arrayOf(R.raw.goldy,R.raw.mtv,R.raw.rasperry,0,0)
        val seanAwards = arrayOf(R.raw.emmy,R.raw.sag,0,0,0)
        val michaelAwards = arrayOf(R.raw.sag,R.raw.alma,0,0,0)
        val akselAwards = arrayOf(R.raw.amanda,R.raw.berlin,0,0,0)
        val jeffAwards = arrayOf(R.raw.emmy,0,0,0,0)
        val donaldAwards = arrayOf(R.raw.emmy,R.raw.mtv,R.raw.golden,R.raw.grammy,0)
        val benedictAwards = arrayOf(R.raw.gold,0,0,0,0)

        val actor1 = Actor("Matt", "Damon", R.drawable.matt, "1970-10-08", "mattdamonteam",weekDays,mattAwards)
        val actor2 = Actor("Jessica", "Chastain",R.drawable.jessica, "1977-03-24", "jessicachastain", moviesJessica,jessicaAwards)
        val actor3 = Actor("Chiwetel ", "Ejiofor",R.drawable.chiwetel, "1977-07-10", "chiwetelejiofor__", moviesChiwetel,chiwetelAwards)
        val actor4 = Actor("Kate ", "Mara",R.drawable.kate, "1983-02-27", "katemara", moviesKate, kateAwards)
        val actor5 = Actor("Sebastian ", "Stan",R.drawable.sebastian, "1982-08-16", "imsebastianstan", moviesSebastian,sebastianAwards)
        val actor6 = Actor("Kristen ", "Wiig",R.drawable.kristen, "1973-08-22", "kristenwiigdaily", moviesKristen,kristenAwards)
        val actor7 = Actor("Sean ", "Bean",R.drawable.sean, "1959-04-27", "sean_bean_official", moviesSean,seanAwards)
        val actor8 = Actor("Michael ", "Peña",R.drawable.michael, "1976-01-13", "mvegapena", moviesMichael,michaelAwards)
        val actor9 = Actor("Aksel ", "Hennie",R.drawable.aksel, "1975-10-29", "akselhennie", moviesAksel,akselAwards)
        val actor10 = Actor("Jeff ", "Daniels",R.drawable.jeff, "1955-02-19", "jeffdanielsofficial", moviesJeff,jeffAwards)
        val actor11 = Actor("Donald ", "Glover",R.drawable.donald, "1983-09-25", "donaldglover", moviesDonald,donaldAwards)
        val actor12 = Actor("Benedict ", "Wong",R.drawable.benedict, "1971-07-03", "wongrel", moviesBenedict,benedictAwards)

        val character1 = Character("Mark","Watney", (resources.getString(R.string.profession_astronaut)),(resources.getString(R.string.rol_principal)),(resources.getString(R.string.mat_position)),actor1,R.drawable.mark,760)
        val character2 = Character("Melissa","Lewis", (resources.getString(R.string.profession_astronaut)),(resources.getString(R.string.rol_principal)),(resources.getString(R.string.melissa_position)),actor2,R.drawable.melissa,760)
        val character3 = Character("Venkat","Kapoor", (resources.getString(R.string.director_mission)),(resources.getString(R.string.rol_principal)),(resources.getString(R.string.director_mission)), actor3,R.drawable.kapoor_ch,0)
        val character4 = Character("Beth ","Johanssen", (resources.getString(R.string.profession_astronaut)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.beth_position)), actor4,R.drawable.beth,760)
        val character5 = Character("Chris ","Beck", (resources.getString(R.string.profession_astronaut)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.chris_position)), actor5,R.drawable.chris,760)
        val character6 = Character("Annie ","Montrose", (resources.getString(R.string.director_relations)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.annie_position)), actor6,R.drawable.annie_chr,0)//
        val character7 = Character("Mitch ","Henderson", (resources.getString(R.string.director_hermes)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.mitch_position)), actor7,R.drawable.mitch_ch,0)
        val character8 = Character("Rick ","Martínez", (resources.getString(R.string.profession_astronaut)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.martinez_position)), actor8,R.drawable.rick,760)
        val character9 = Character("Alex ","Vogel", (resources.getString(R.string.profession_astronaut)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.alex_position)), actor9,R.drawable.alex,760)
        val character10 = Character("Teddy ","Sanders", (resources.getString(R.string.director_text)),(resources.getString(R.string.rol_principal)),(resources.getString(R.string.teddy_position)), actor10,R.drawable.teddy_ch,0)
        val character11 = Character("Rick ","Purnell", (resources.getString(R.string.text_astrodynamics)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.rich_position)), actor11,R.drawable.rick_ch,0)
        val character12 = Character("Bruce ","Ng", (resources.getString(R.string.drector_jet_text)),(resources.getString(R.string.rol_second)),(resources.getString(R.string.bruce_position)), actor12,R.drawable.bruce_ch,0)

        setDataCharacter(btnJessica, character2,actor2)
        setDataCharacter(btnMatt, character1,actor1)
        setDataCharacter(btnChiwetel, character3,actor3)
        setDataCharacter(btnKate, character4,actor4)
        setDataCharacter(btnSebastian, character5,actor5)
        setDataCharacter(btnKristen, character6,actor6)
        setDataCharacter(btnMichael, character7,actor7)
        setDataCharacter(btnSean, character8,actor8)
        setDataCharacter(btnAksel, character9,actor9)
        setDataCharacter(btnJeff, character10,actor10)
        setDataCharacter(btnDonald, character11,actor11)
        setDataCharacter(btnBenedict, character12,actor12)


        buttonProfileActor.setOnClickListener {
            val i = Intent(this, ProfileActor::class.java)
            prefs.run {
                saveFullName("${character.name} ${character.lastName}" )
                saveImage(character.imageCharacter)
                saveProfession(character.profession)
                savePosition(character.position)
                saveRol(character.rol)
                saveDayOut(character.daysOut)
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

    private fun setDataCharacter(btnCharacter:ImageButton, characterAux: Character, actorAux: Actor){
        val imageView: ImageView = findViewById(R.id.imageView)

        val txtActorName = findViewById<TextView>(R.id.actorName)
        val txtActorBornDate = findViewById<TextView>(R.id.actorBornDate)
        //val txtActorAwards = findViewById<TextView>(R.id.actorAwards)

        val instagram: ImageView = findViewById(R.id.imageInstagram)

        val imageViewMovie1: ImageView = findViewById(R.id.movie1)
        val imageViewMovie2: ImageView = findViewById(R.id.movie2)
        val imageViewMovie3: ImageView = findViewById(R.id.movie3)
        val imageViewMovie4: ImageView = findViewById(R.id.movie4)
        val imageViewMovie5: ImageView = findViewById(R.id.movie5)

        val imageViewAward1: ImageView = findViewById(R.id.award1)
        val imageViewAward2: ImageView = findViewById(R.id.award2)
        val imageViewAward3: ImageView = findViewById(R.id.award3)
        val imageViewAward4: ImageView = findViewById(R.id.award4)
        val imageViewAward5: ImageView = findViewById(R.id.award5)

        btnCharacter.setOnClickListener{
            imageView.setBackgroundResource(actorAux.image)
            txtActorName.text = actorAux.fistName + " " + actorAux.lastName
            txtActorBornDate.text = " " + actorAux.bornDate
            //txtActorAwards.text = actorAux.awards[0]
            character = characterAux

            imageViewAward1.setBackgroundResource(actorAux.award_a[0])
            imageViewAward2.setBackgroundResource(actorAux.award_a[1])
            imageViewAward3.setBackgroundResource(actorAux.award_a[2])
            imageViewAward4.setBackgroundResource(actorAux.award_a[3])
            imageViewAward5.setBackgroundResource(actorAux.award_a[4])

            imageViewMovie1.setBackgroundResource(actorAux.movie_a[0])
            imageViewMovie2.setBackgroundResource(actorAux.movie_a[1])
            imageViewMovie3.setBackgroundResource(actorAux.movie_a[2])
            imageViewMovie4.setBackgroundResource(actorAux.movie_a[3])
            imageViewMovie5.setBackgroundResource(actorAux.movie_a[4])

            instagram.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, actorAux.getInstagram(actorAux.instagram))
                startActivity(intent)
            }
        }
    }

    private fun restartApplication(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
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