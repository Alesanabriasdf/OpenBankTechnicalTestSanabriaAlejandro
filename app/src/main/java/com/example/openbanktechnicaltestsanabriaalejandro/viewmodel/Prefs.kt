package com.example.openbanktechnicaltestsanabriaalejandro.viewmodel

import android.content.Context

class Prefs(val context: Context) {

    private val storage = context.getSharedPreferences("idcharacter",0)!!

    fun colectId(id: String){
        storage.edit().putString("characterId",id).apply()
    }
    fun getId():String{
        return storage.getString("characterId","")!!
    }
}