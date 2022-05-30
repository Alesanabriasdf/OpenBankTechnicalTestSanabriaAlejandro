package com.example.openbanktechnicaltestsanabriaalejandro.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openbanktechnicaltestsanabriaalejandro.model.DescriptionOfHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.viewmodel.usecases.GetDetailOfSuperHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SuperHeroDetailViewModel @Inject constructor(private val getDetailOfSuperHero: GetDetailOfSuperHero) :
    ViewModel() {

    var descriptionOfHero = MutableLiveData<DescriptionOfHeroData>()

    val loading = MutableLiveData<Boolean>()

    val showSorryItems = MutableLiveData<Boolean>()

    val showDescriptionItems = MutableLiveData<Boolean>()

    val thereIsNoInternet = MutableLiveData<Boolean>()

    fun onGetDetail() {
        viewModelScope.launch {
            loading.postValue(true)
            try {
                val descriptionHero = getDetailOfSuperHero()
                if (descriptionHero.descriptionOfHero != "") {
                    showSorryItems.postValue(false)
                    showDescriptionItems.postValue(true)
                    descriptionOfHero.value = descriptionHero
                    loading.postValue(false)
                } else {
                    showSorryItems.postValue(true)
                    showDescriptionItems.postValue(false)
                    loading.postValue(false)
                }
            } catch (e: Exception) {
                loading.postValue(false)
                thereIsNoInternet.postValue(true)
            }
        }
    }
}