package com.example.myapplication
import android.content.Context

class Prefs(context: Context) {
    val SHARE_PREFERENCE = "Mydtb"
    val SHARE_NAME = "NAME"
    val SHARE_ROL = "ROL"
    val SHARE_IMAGE = "IMAGE"
    val SHARE_PROFESSION = "PROFESSION"
    val SHARE_DAYS_OUT = "DAYS_OUT"
    val SHARE_POSITION = "POSITION"

    val storage = context.getSharedPreferences(SHARE_PREFERENCE, 0)

    fun saveFullName(name:String){
        storage.edit().putString(SHARE_NAME, name).apply()
    }

    fun saveProfession(name:String){
        storage.edit().putString(SHARE_PROFESSION, name).apply()
    }

    fun saveRol(rol: String){
        storage.edit().putString(SHARE_ROL, rol).apply()
    }

    fun saveDayOut(day: Int){
        storage.edit().putInt(SHARE_DAYS_OUT, day).apply()
    }

    fun getDayOut():Int{
        return storage.getInt(SHARE_DAYS_OUT, 0)
    }

    fun saveImage(image:Int){
        storage.edit().putInt(SHARE_IMAGE, image).apply()
    }

    fun getFullName():String{
        return storage.getString(SHARE_NAME, "")!!
    }

    fun getChRol():String{
        return storage.getString(SHARE_ROL, "")!!
    }

    fun getProfession():String{
        return storage.getString(SHARE_PROFESSION, "")!!
    }

    fun getImage():Int{
        return storage.getInt(SHARE_IMAGE, 0)
    }

    fun savePosition(position:String){
        storage.edit().putString(SHARE_POSITION, position).apply()
    }
    fun getPosition():String{
        return storage.getString(SHARE_POSITION, "")!!
    }




    fun wipe(){
        storage.edit().clear().apply()
    }
}