package com.example.openbanktechnicaltestsanabriaalejandro.database.descriptionentity

import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.forthedescription.SuperHeroByIdCharacterService
import com.example.openbanktechnicaltestsanabriaalejandro.database.SuperHeroDao
import com.example.openbanktechnicaltestsanabriaalejandro.model.DescriptionOfHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.model.changeToDescriptionOfHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.model.fromJsonToGetDescription
import javax.inject.Inject



class SuperHeroByIdCharacterRepository @Inject constructor(
    private val api: SuperHeroByIdCharacterService,
    private val SuperHeroDao: SuperHeroDao
) {

    suspend fun getDescriptionOfHeroFromApiService(): DescriptionOfHeroData {
        val response = api.getSuperHeroById()
        return response.fromJsonToGetDescription()
    }

    suspend fun getDescriptionOfSuperHeroFromDataBase(): DescriptionOfHeroData {
        val response: SuperHeroDescriptionEntity = SuperHeroDao.getDescriptionOfSuperHeroFromDataBase()
        return response.changeToDescriptionOfHeroData()
    }

    suspend fun insertSuperHeroes(superHero: SuperHeroDescriptionEntity){
        SuperHeroDao.insertDescriptionOfHero(superHero)
    }

    suspend fun clearSuperHeroesDescriptions() {
        SuperHeroDao.deleteSuperHeroDescription()
    }
}
