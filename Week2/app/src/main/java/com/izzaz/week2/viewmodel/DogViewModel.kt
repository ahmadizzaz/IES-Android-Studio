package com.izzaz.week2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izzaz.week2.model.DogModel

class DogViewModel : ViewModel() {

    private var dogList: MutableLiveData<List<DogModel>>? = null

    internal fun getDogList() : MutableLiveData<List<DogModel>>{
        if (dogList == null){
            dogList = MutableLiveData()
            loadDog()
        }
        return dogList as MutableLiveData<List<DogModel>>
    }

    private fun loadDog(){
         val dogListInit: List<DogModel> = listOf(
            DogModel(
                "https://images.dog.ceo/breeds/chihuahua/n02085620_8491.jpg",
                "wawa",
                "chihuahua"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/mastiff-bull/n02108422_3184.jpg",
                "mastika",
                "mastiff-bull"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/schipperke/n02104365_1841.jpg",
                "cheapskate",
                "schipperke"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/mountain-bernese/n02107683_7196.jpg",
                "chibi",
                "mountain-bernese"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/terrier-scottish/n02097298_13452.jpg",
                "harry kane",
                "terrier"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/dachshund/puppy-1006024_640.jpg",
                "lebron",
                "dachshund"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/otterhound/n02091635_3072.jpg",
                "comot",
                "otterhound"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/coonhound/n02089078_2841.jpg",
                "cotton",
                "coonhound"
            ),
            DogModel(
                "https://images.dog.ceo/breeds/puggle/IMG_104450.jpg",
                "fluffy",
                "puggle"
            )
        )
        dogList?.postValue(dogListInit)
    }
}


