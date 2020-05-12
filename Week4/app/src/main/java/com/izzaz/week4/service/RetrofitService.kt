package com.izzaz.week4.service

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.izzaz.week4.datamodel.Pokemon
import com.izzaz.week4.interfaces.ApiEndpoint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private val livePokemonData: MutableLiveData<List<Pokemon>> = MutableLiveData()


    companion object Factory{
        private const val BASE_URL = "https://5e6cf13a4e86f8001618c827.mockapi.io/"
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiEndpoint{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiEndpoint::class.java)
        }
    }

    @SuppressLint("CheckResult")
    fun loadPokemonData(): MutableLiveData<List<Pokemon>>?{
        val dataObservable : Observable<List<Pokemon>> = create().getPokemon()
        dataObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result->
                livePokemonData.value = result
            },{ error->
                Log.e("Error",error.toString())
            })
        return livePokemonData
    }
}