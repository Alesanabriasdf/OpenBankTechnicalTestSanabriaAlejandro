package com.example.openbanktechnicaltestsanabriaalejandro.viewmodel.usecases

import com.example.openbanktechnicaltestsanabriaalejandro.database.descriptionentity.SuperHeroByIdCharacterRepository
import com.example.openbanktechnicaltestsanabriaalejandro.model.DescriptionOfHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.model.changeDescriptionOfHeroDataToEntityTypeData
import javax.inject.Inject

class GetDetailOfSuperHero @Inject constructor(private val repository: SuperHeroByIdCharacterRepository) {
    suspend operator fun invoke():DescriptionOfHeroData{
        repository.clearSuperHeroesDescriptions()
        val superHeroDescription = repository.getDescriptionOfHeroFromApiService()
        return if (superHeroDescription.descriptionOfHero == "") {
            DescriptionOfHeroData("")
        }else {
            repository.clearSuperHeroesDescriptions()
            repository.insertSuperHeroes(superHeroDescription.changeDescriptionOfHeroDataToEntityTypeData())
            repository.getDescriptionOfSuperHeroFromDataBase() }
    }
}