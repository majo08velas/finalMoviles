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
import java.util.*

class ProfileActor : AppCompatActivity() {

    lateinit var lang: String
    private lateinit var btnActor: Button
    private lateinit var rol_text: TextView
    private lateinit var position_text: TextView
    private lateinit var profession_text: TextView
    private lateinit var days_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_actor)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val text: TextView = findViewById(R.id.actor_name_text)
        rol_text = findViewById(R.id.character_rol)
        position_text = findViewById(R.id.character_position)
        days_text = findViewById(R.id.character_days_out)
        profession_text = findViewById(R.id.character_profession)
        //val dateBorn: TextView = findViewById(R.id.actor_born_text)
        val imageView: ImageView = findViewById(R.id.imageView3)
        btnActor = findViewById(R.id.buttonActor)

        btnActor.setOnClickListener{finish()}
        val bundle = intent.extras
        lang = bundle?.get("LANG").toString()
        updateResource(lang)


        text.text = prefs.getFullName()
        rol_text.text = prefs.getChRol()
        days_text.text = " " + prefs.getDayOut().toString()
        profession_text.text = prefs.getProfession()
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

    fun updateResource(idioma:String){
        val recursos = resources
        val displayMetrics = recursos.displayMetrics
        val configuracion = resources.configuration

        configuracion.setLocale(Locale(idioma))
        recursos.updateConfiguration(configuracion, displayMetrics)
        configuracion.locale = Locale(idioma)
        resources.updateConfiguration(configuracion, displayMetrics)

        btnActor.text = recursos.getString(R.string.btn_actor)
        rol_text.text = recursos.getString(R.string.rol_text)
        position_text.text = recursos.getString(R.string.posi_text)
        profession_text.text = recursos.getString(R.string.prof_text)
        days_text.text = recursos.getString(R.string.days_text)

    }
}