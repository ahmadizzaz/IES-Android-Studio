package com.izzaz.week2.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout.VERTICAL

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.izzaz.week2.adapter.FoodItemAdapter
import com.izzaz.week2.viewmodel.FoodViewModel
import com.izzaz.week2.R
import kotlinx.android.synthetic.main.screen1.*


class MainActivity : AppCompatActivity() {

    private lateinit var model: FoodViewModel

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen1)

        model = ViewModelProvider(this).get(FoodViewModel::class.java)
        recyclerView1.layoutManager = LinearLayoutManager(this)
//        recyclerView1.layoutManager = GridLayoutManager(this,3, VERTICAL,false)

        model.getFoodList().observe(this,Observer{ food->
            recyclerView1.adapter = FoodItemAdapter(food)
        })


        btnNext.setOnClickListener{
            val name: String = etName.text.toString()
            val age: String = etAge.text.toString()

            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("user_name", name)
            intent.putExtra("user_age", age)
            startActivity(intent)
        }
    }
}
