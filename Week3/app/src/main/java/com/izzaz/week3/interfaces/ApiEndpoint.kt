package com.izzaz.week3.interfaces

import com.izzaz.week3.datamodel.PhotoModel
import retrofit2.Call
import retrofit2.http.GET

import io.reactivex.Observable;

interface ApiEndpoint{

    @GET("/v2/list/")
    fun getData2(): Observable<List<PhotoModel>>
}