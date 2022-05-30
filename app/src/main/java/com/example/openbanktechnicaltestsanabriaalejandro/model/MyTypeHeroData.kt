package com.example.openbanktechnicaltestsanabriaalejandro.model

import com.example.openbanktechnicaltestsanabriaalejandro.database.listentity.SuperHeroesListEntity
import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.GlobalDto
import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.Thumbnail

data class MyTypeHeroData(
    val id: String,
    val image: String,
    val superHeroName: String
)

fun GlobalDto.fromJsonToMyDataType(): List<MyTypeHeroData> {
    val listSuperHero: MutableList<MyTypeHeroData> = mutableListOf()
    data.results.forEach {
        val changedThumbnailToString = changeThumbnailToString(it.thumbnail)
        listSuperHero.add(
            MyTypeHeroData(
                id = it.id,
                image = changedThumbnailToString,
                superHeroName = it.name,
            )
        )
    }
    return listSuperHero
}

private fun changeThumbnailToString(thumbnail: Thumbnail): String {
    val changeProtocol = thumbnail.path.split(":")
    return "https:" + changeProtocol[1] + "." + thumbnail.extension
}

fun SuperHeroesListEntity.changeToMyTypeHeroData() =
    MyTypeHeroData(id = idOfHero, image = image, superHeroName = superHeroName)

fun MyTypeHeroData.changeToSuperHeroesListEntityTypeData() = SuperHeroesListEntity(
    idOfHero = id,
    image = image,
    superHeroName = superHeroName
)
