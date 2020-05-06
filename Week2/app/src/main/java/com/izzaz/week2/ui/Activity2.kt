package com.izzaz.week2.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.GridLayout.VERTICAL
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.izzaz.week2.R
import com.izzaz.week2.adapter.DogModelAdapter
import com.izzaz.week2.viewmodel.DogViewModel
import kotlinx.android.synthetic.main.screen2.*

class Activity2 : AppCompatActivity() {

    private lateinit var model:DogViewModel

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen2)

        val bundle: Bundle? = intent.extras
        val name = tvName.text.toString()+ " " + bundle!!.getString("user_name")
        val age = tvAge.text.toString() + " " + bundle.getString("user_age")
        tvName.text = name
        tvAge.text = age

        model = ViewModelProvider(this).get(DogViewModel::class.java)
        recyclerView2.layoutManager = GridLayoutManager(this,3,VERTICAL,false)

        model.getDogList().observe(this, Observer { dog->
            recyclerView2.adapter = DogModelAdapter(dog)

        })


    }
}