package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

open class Actor(val fistName: String, val lastName: String, val image:Int, val bornDate: String){

    val awards = arrayOf("")
    val movies = arrayOf("El Marciano")
    val instagram: String = ""

    @RequiresApi(Build.VERSION_CODES.O)
    fun showsAge():String{
        val dateNow = LocalDate.now()
        LocalDate.parse(bornDate)
        return ChronoUnit.YEARS.between(LocalDate.parse(bornDate), dateNow).toString()

    }
}

/*
*
* picture: File
* web: [Url] = Uri.parse
* instagram: String
*/
