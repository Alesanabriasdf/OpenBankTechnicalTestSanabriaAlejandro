package com.example.openbanktechnicaltestsanabriaalejandro.dependencyinjection

import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.AppConstants
import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.forthelist.MarvelApiService
import com.example.openbanktechnicaltestsanabriaalejandro.apiservice.forthedescription.MarvelApiServiceByIdCharacter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideSuperHeroApiService(retrofit: Retrofit): MarvelApiService {
        return retrofit.create(MarvelApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideSuperHeroApiServiceByIdCharacter(retrofit: Retrofit) : MarvelApiServiceByIdCharacter {
        return retrofit.create(MarvelApiServiceByIdCharacter::class.java)
    }
}