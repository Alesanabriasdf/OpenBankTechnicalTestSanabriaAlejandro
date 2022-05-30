package com.example.openbanktechnicaltestsanabriaalejandro.viewmodel.usecases

import com.example.openbanktechnicaltestsanabriaalejandro.database.listentity.SuperHeroesRepository
import com.example.openbanktechnicaltestsanabriaalejandro.model.MyTypeHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.model.changeToSuperHeroesListEntityTypeData
import javax.inject.Inject

class GetAllHeroes @Inject constructor(private val repository: SuperHeroesRepository) {

    suspend operator fun invoke(): List<MyTypeHeroData> {
        val superHeroes = repository.getAllSuperHeroesFromApi()
        if (superHeroes.isNotEmpty()) {
            repository.clearSuperHeroes()
            repository.insertSuperHeroes(superHeroes.map { it.changeToSuperHeroesListEntityTypeData() })
            return repository.getAllSuperHeroesFromDataBase()
        }else {
            return emptyList()
        }
    }
}