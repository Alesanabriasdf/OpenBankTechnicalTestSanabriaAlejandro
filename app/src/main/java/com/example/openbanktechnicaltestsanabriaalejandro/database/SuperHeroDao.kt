package com.example.openbanktechnicaltestsanabriaalejandro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.openbanktechnicaltestsanabriaalejandro.database.descriptionentity.SuperHeroDescriptionEntity
import com.example.openbanktechnicaltestsanabriaalejandro.database.listentity.SuperHeroesListEntity

@Dao
interface SuperHeroDao {

    @Query ("SELECT * FROM super_heroes_list_table ORDER BY super_hero_name ASC")
    suspend fun getAllHeroes():List<SuperHeroesListEntity>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHeroes(superHeroes: List<SuperHeroesListEntity>)

    @Query ("DELETE FROM super_heroes_list_table" )
    suspend fun deleteAllSuperHeroes()

    @Query ("SELECT * FROM super_hero_description_table")
    suspend fun getDescriptionOfSuperHeroFromDataBase():SuperHeroDescriptionEntity

    @Insert
    suspend fun insertDescriptionOfHero(superHero: SuperHeroDescriptionEntity)

    @Query ("DELETE FROM super_hero_description_table" )
    suspend fun deleteSuperHeroDescription()
}