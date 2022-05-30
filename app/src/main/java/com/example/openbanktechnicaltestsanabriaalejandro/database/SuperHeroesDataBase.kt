package com.example.openbanktechnicaltestsanabriaalejandro.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.openbanktechnicaltestsanabriaalejandro.database.descriptionentity.SuperHeroDescriptionEntity
import com.example.openbanktechnicaltestsanabriaalejandro.database.listentity.SuperHeroesListEntity

@Database (entities = [SuperHeroesListEntity::class, SuperHeroDescriptionEntity::class], version = 1)
abstract class SuperHeroesDataBase: RoomDatabase(){
    abstract fun getSuperHeroDao():SuperHeroDao
}