package com.izzaz.week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izzaz.week4.datamodel.Pokemon
import com.izzaz.week4.service.RetrofitService

class PokemonViewModel : ViewModel() {
     private val mService = RetrofitService()

    fun getPokemonData() : MutableLiveData<List<Pokemon>>?{
        return mService.loadPokemonData()
    }
}