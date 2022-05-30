package com.example.openbanktechnicaltestsanabriaalejandro.apiservice.forthedescription

import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.AppConstants
import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.GlobalDto
import com.example.openbanktechnicaltestsanabriaalejandro.view.MainActivity.Companion.prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class SuperHeroByIdCharacterService @Inject constructor(private val api: MarvelApiServiceByIdCharacter) {

    val charactherId = prefs.getId()

    suspend fun getSuperHeroById(): GlobalDto {
        return withContext(Dispatchers.Default) {
            val call: Response<GlobalDto> =
                api.getSuperHeroById(
                    characterId = charactherId,
                    limit = AppConstants.limit,
                    publicKey = AppConstants.PUBLIC_KEY,
                    ts = AppConstants.ts,
                    hash = AppConstants.hash()
                )
            call.body()!!
        }
    }
}