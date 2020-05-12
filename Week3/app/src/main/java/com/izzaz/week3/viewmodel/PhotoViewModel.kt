package com.izzaz.week3.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izzaz.week3.datamodel.PhotoModel
import com.izzaz.week3.service.RetrofitService
import io.reactivex.disposables.Disposable

class PhotoViewModel : ViewModel() {

    private val mService = RetrofitService()

    fun getPhotoData(): MutableLiveData<List<PhotoModel>>?{
        return mService.loadPhotoData()
    }
}