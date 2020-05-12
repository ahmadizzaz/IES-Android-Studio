package com.izzaz.week3.service

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.izzaz.week3.datamodel.PhotoModel
import com.izzaz.week3.interfaces.ApiEndpoint
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

import io.reactivex.schedulers.Schedulers

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class RetrofitService {
    private val liveUserResponse: MutableLiveData<List<PhotoModel>> = MutableLiveData()

    companion object Factory{
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiEndpoint{

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://picsum.photos/")
                .build()

            return retrofit.create(ApiEndpoint::class.java)
        }
    }

    @SuppressLint("CheckResult")
    fun loadPhotoData(): MutableLiveData<List<PhotoModel>>?{

        val dataObservable : Observable<List<PhotoModel>> = create().getData2()
        dataObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ result ->
                liveUserResponse.value = result
            },{error ->
                Log.e("ERROR HERE", error.toString())
            })
        return liveUserResponse
    }

}