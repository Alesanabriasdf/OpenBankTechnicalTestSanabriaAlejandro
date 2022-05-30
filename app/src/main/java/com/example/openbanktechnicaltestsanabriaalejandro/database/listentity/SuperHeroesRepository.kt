package com.example.openbanktechnicaltestsanabriaalejandro.database.listentity

import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.forthelist.SuperHeroesService
import com.example.openbanktechnicaltestsanabriaalejandro.database.SuperHeroDao
import com.example.openbanktechnicaltestsanabriaalejandro.model.MyTypeHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.model.changeToMyTypeHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.model.fromJsonToMyDataType
import javax.inject.Inject

class SuperHeroesRepository @Inject constructor(
    private val api: SuperHeroesService,
    private val SuperHeroDao: SuperHeroDao
) {

    suspend fun getAllSuperHeroesFromApi(): List<MyTypeHeroData> {
        val response = api.getHeroes()
        return response.fromJsonToMyDataType()
    }

    suspend fun getAllSuperHeroesFromDataBase(): List<MyTypeHeroData> {
        val response: List<SuperHeroesListEntity> = SuperHeroDao.getAllHeroes()
        return response.map { it.changeToMyTypeHeroData() }
    }

    suspend fun insertSuperHeroes(superHeroes:List<SuperHeroesListEntity>){
        SuperHeroDao.insertAllHeroes(superHeroes)
    }

    suspend fun clearSuperHeroes() {
        SuperHeroDao.deleteAllSuperHeroes()
    }
}
