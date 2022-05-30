package com.example.openbanktechnicaltestsanabriaalejandro.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openbanktechnicaltestsanabriaalejandro.model.MyTypeHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.viewmodel.usecases.GetAllHeroes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperHeroesListViewModel @Inject constructor(private val getAllHeroes: GetAllHeroes) :
    ViewModel() {

    var listOfAllHeroes = MutableLiveData<List<MyTypeHeroData>?>()

    val loading = MutableLiveData<Boolean>()

    val showError = MutableLiveData<Boolean>()

    fun onGetAllHeroes() {
        viewModelScope.launch {
            loading.postValue(true)
            try {
                val listWithHeroes = getAllHeroes()
                listOfAllHeroes.value = listWithHeroes
                loading.postValue(false)
            } catch (e: Exception) {
                loading.postValue(false)
                showError.postValue(true)
            }
        }
    }
}