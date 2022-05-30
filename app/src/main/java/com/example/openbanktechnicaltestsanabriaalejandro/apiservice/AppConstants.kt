package com.example.openbanktechnicaltestsanabriaalejandro.apiservice

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class AppConstants {
    companion object{
        const val BASE_URL = "https://gateway.marvel.com:443/"
        const val LIST_END_POINT = "v1/public/characters"
        const val ID_END_POINT = "v1/public/characters/{characterId}"
        const val PUBLIC_KEY = "51a1f3f36fe0421d74e97437a5ffd5c1"
        const val PRIVATE_KEY = "00913318b0867364953cd47a07a8d0441fe4b159"
        const val limit = "20"
        val ts = Timestamp(System.currentTimeMillis()).time.toString()

        fun hash():String {
            val input = "$ts$PRIVATE_KEY$PUBLIC_KEY"
            val md = MessageDigest.getInstance("md5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}

