package com.izzaz.week4.interfaces

import com.izzaz.week4.datamodel.Pokemon
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("api/v1/pokemon")
    fun getPokemon(): Observable<List<Pokemon>>
}