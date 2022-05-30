package com.example.openbanktechnicaltestsanabriaalejandro.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.example.openbanktechnicaltestsanabriaalejandro.database.SuperHeroesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context)
            = Room.databaseBuilder(context,SuperHeroesDataBase::class.java,"super_Hero_database").build()

    @Singleton
    @Provides
    fun providesSuperHeroDao(db:SuperHeroesDataBase)=db.getSuperHeroDao()
}