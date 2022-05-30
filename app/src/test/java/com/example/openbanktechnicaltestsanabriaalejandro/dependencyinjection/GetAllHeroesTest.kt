package com.example.openbanktechnicaltestsanabriaalejandro.dependencyinjection

import com.example.openbanktechnicaltestsanabriaalejandro.database.listentity.SuperHeroesRepository
import com.example.openbanktechnicaltestsanabriaalejandro.model.MyTypeHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.viewmodel.usecases.GetAllHeroes
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetAllHeroesTest{

    @RelaxedMockK
    private lateinit var repository: SuperHeroesRepository

    lateinit var getAllHeroes: GetAllHeroes

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getAllHeroes = GetAllHeroes(repository)
    }

    @Test
    fun `when the api does not return the GlobalDto`()= runBlocking{
        //given
        coEvery { repository.getAllSuperHeroesFromApi() } returns emptyList()
        //then
        val list1 = getAllHeroes()
        //when
        coVerify (exactly = 0) { repository.clearSuperHeroes() }
        coVerify (exactly = 0) { repository.insertSuperHeroes(any()) }
        coVerify (exactly = 0) { repository.getAllSuperHeroesFromDataBase() }
        assert(list1==repository.getAllSuperHeroesFromApi())
    }

    @Test
    fun `when the api does return the GlobalDto`()= runBlocking{
        //given
        val list2 = listOf(MyTypeHeroData("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/portrait_xlarge.jpg",
            "3-D Man",
            ""))
        coEvery { repository.getAllSuperHeroesFromApi() } returns list2
        coEvery { repository.getAllSuperHeroesFromDataBase() } returns list2

        //then
        val listOfHeroes = getAllHeroes()

        //when
        coVerify (exactly = 1) { repository.clearSuperHeroes() }
        coVerify (exactly = 1) { repository.insertSuperHeroes(any()) }
        coVerify (exactly = 1) { repository.getAllSuperHeroesFromDataBase() }

        assert(list2 == listOfHeroes)
    }
}