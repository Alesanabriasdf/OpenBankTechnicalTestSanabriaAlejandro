package com.example.openbanktechnicaltestsanabriaalejandro.apiservice.forthedescription

import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.AppConstants
import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.GlobalDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiServiceByIdCharacter {
    @GET(AppConstants.ID_END_POINT)
    suspend fun getSuperHeroById(
        @Path("characterId") characterId:String,
        @Query("limit") limit: String,
        @Query("apikey") publicKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    )
            : Response<GlobalDto>
}