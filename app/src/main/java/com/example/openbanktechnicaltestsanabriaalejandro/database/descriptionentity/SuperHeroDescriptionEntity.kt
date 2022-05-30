package com.example.openbanktechnicaltestsanabriaalejandro.database.descriptionentity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "super_hero_description_table")
data class SuperHeroDescriptionEntity (

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int=0,
    @ColumnInfo(name = "description") val descriptionSuperHero: String,

)