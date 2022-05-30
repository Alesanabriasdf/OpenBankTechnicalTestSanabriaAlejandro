package com.example.openbanktechnicaltestsanabriaalejandro.apiservice.forthelist

import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.AppConstants
import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.GlobalDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class SuperHeroesService @Inject constructor(private val api: MarvelApiService) {

    suspend fun getHeroes(): GlobalDto {
        return withContext(Dispatchers.IO) {
            val call: Response<GlobalDto> =
                api.getSuperHero(
                    limit = AppConstants.limit,
                    publicKey = AppConstants.PUBLIC_KEY,
                    ts = AppConstants.ts,
                    hash = AppConstants.hash()
                )
            call.body()!!
        }
    }
}