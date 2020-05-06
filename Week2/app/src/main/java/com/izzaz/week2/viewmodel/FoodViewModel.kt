package com.izzaz.week2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izzaz.week2.model.FoodItem

class FoodViewModel : ViewModel() {

    private var foodList: MutableLiveData<List<FoodItem>>? = null

    internal fun getFoodList() : MutableLiveData<List<FoodItem>>{
        if (foodList == null){
            foodList = MutableLiveData()
            loadFood()
        }
        return foodList as MutableLiveData<List<FoodItem>>
    }

    private fun loadFood(){
        val foodListInit = ArrayList<FoodItem>()
        foodListInit.add(FoodItem("Nasi Goreng"))
        foodListInit.add(FoodItem("Nasi Lemak"))
        foodListInit.add(FoodItem("Roti Canai"))
        foodListInit.add(FoodItem("Nasi Goreng"))
        foodListInit.add(FoodItem("Nasi Goreng"))
        foodListInit.add(FoodItem("Nasi Goreng"))
        foodListInit.add(FoodItem("Nasi Goreng"))
        foodList?.postValue(foodListInit)
    }
//    val foodList: MutableList<FoodItem> = mutableListOf(
//        FoodItem("Nasi Goreng"),
//        FoodItem("Nasi Lemak"),
//        FoodItem("Roti Canai"),
//        FoodItem("Roti Canai"),
//        FoodItem("Roti Canai"),
//        FoodItem("Roti Canai"),
//        FoodItem("Roti Canai")
//    )
}


