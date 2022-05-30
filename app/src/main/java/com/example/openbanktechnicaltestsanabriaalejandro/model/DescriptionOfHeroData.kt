package com.example.openbanktechnicaltestsanabriaalejandro.model

import com.example.openbanktechnicaltestsanabriaalejandro.database.descriptionentity.SuperHeroDescriptionEntity
import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.GlobalDto

data class DescriptionOfHeroData (
    val descriptionOfHero:String
        )

fun GlobalDto.fromJsonToGetDescription()= DescriptionOfHeroData(data.results.first().description)

fun SuperHeroDescriptionEntity.changeToDescriptionOfHeroData() = DescriptionOfHeroData(descriptionOfHero = descriptionSuperHero)

fun DescriptionOfHeroData.changeDescriptionOfHeroDataToEntityTypeData() = SuperHeroDescriptionEntity( descriptionSuperHero = descriptionOfHero )
