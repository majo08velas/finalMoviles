package com.example.myapplication
import android.content.Context

class Prefs(context: Context) {
    val SHARE_PREFERENCE = "Mydtb"
    val SHARE_NAME = "NAME"
    val SHARE_DATE_BORN = "DATE"
    val SHARE_IMAGE = "IMAGE"
    val SHARE_MOVIES = "MOVIE"

    val storage = context.getSharedPreferences(SHARE_PREFERENCE, 0)

    fun saveFullName(name:String){
        storage.edit().putString(SHARE_NAME, name).apply()
    }

    fun saveDateBorn(name:String){
        storage.edit().putString(SHARE_DATE_BORN, name).apply()
    }

    fun saveMovies(movies: Array<String>){
        storage.edit().putStringSet(SHARE_MOVIES, movies.toSet()).apply()
    }

    fun saveImage(image:Int){
        storage.edit().putInt(SHARE_IMAGE, image).apply()
    }

    fun getFullName():String{
        return storage.getString(SHARE_NAME, "")!!
    }

    fun getDateBorn():String{
        return storage.getString(SHARE_DATE_BORN, "")!!
    }

    fun getImage():Int{
        return storage.getInt(SHARE_IMAGE, 0)
    }


    fun wipe(){
        storage.edit().clear().apply()
    }
}