package com.example.myapplication

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

open class Actor(val fistName: String, val lastName: String, val image:Int, val bornDate: String,val instagram: String, val movie_a: Array<Int>, val award_a: Array<Int>,){

    val awards = arrayOf("Algo")
    val movies = arrayOf("El Marciano")

    fun getInstagram(instagram: String): Uri? {
        return Uri.parse("https://www.instagram.com/$instagram")
    }

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
