package com.example.openbanktechnicaltestsanabriaalejandro.database.listentity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "super_heroes_list_table")
data class SuperHeroesListEntity (

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id") val id:Int=0,
    @ColumnInfo (name = "id2") val idOfHero: String,
    @ColumnInfo (name = "image") val image: String,
    @ColumnInfo (name = "super_hero_name") val superHeroName: String
)