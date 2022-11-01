package com.example.myapplication
import android.content.Context

class Prefs(context: Context) {
    val SHARE_NAME = "Mydtb"

    val storage = context.getSharedPreferences(SHARE_NAME, 0)

    fun saveName(key:String,name:String){
        storage.edit().putString(key, name).apply()
    }

    fun saveImage(key:String,image:Int){
        storage.edit().putInt(key, image).apply()
    }

    fun getName():String{
        return storage.getString("name", "")!!
    }

    fun getImage():Int{
        return storage.getInt("image", 0)
    }


    fun wipe(){
        storage.edit().clear().apply()
    }
}