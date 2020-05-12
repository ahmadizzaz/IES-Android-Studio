package com.izzaz.week3.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.izzaz.week3.R
import com.izzaz.week3.adapter.PhotoAdapter
import com.izzaz.week3.datamodel.PhotoModel
import com.izzaz.week3.interfaces.ItemClickListener
import com.izzaz.week3.viewmodel.PhotoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.izzaz.week3.adapter.AuthorAdapter
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mPhotoViewModel: PhotoViewModel
    private lateinit var liveAuthorResponse: MutableList<String>

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewLayouts()
        getPhotoList()
    }

    private fun getPhotoList(){
        liveAuthorResponse = mutableListOf<String>()
        mPhotoViewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)

        mPhotoViewModel.getPhotoData()?.observe(this, Observer<List<PhotoModel>>{ photoList ->
            Observable.fromIterable(photoList)
                .subscribeOn(Schedulers.io())
                .map { m-> m.author }
                .subscribe{value ->
                    liveAuthorResponse.add(value)
                    println("This is the author $liveAuthorResponse")
                }
            recyclerView.adapter = PhotoAdapter(this,photoList as ArrayList<PhotoModel>,object : ItemClickListener{
                override fun onItemClick(pos: Int) {
                    Toast.makeText(applicationContext,"item $pos clicked",Toast.LENGTH_LONG).show()
                }
            })
            recyclerView2.adapter = AuthorAdapter(this,liveAuthorResponse as ArrayList<String>,object : ItemClickListener{
                override fun onItemClick(pos: Int) {
                    Toast.makeText(applicationContext,"item $pos clicked",Toast.LENGTH_LONG).show()
                }
            })
        })
    }

    @SuppressLint("WrongConstant")
    private fun setViewLayouts(){
        gridLayoutManager = GridLayoutManager(this,2, GridLayout.VERTICAL,false)
        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.hasFixedSize()
        recyclerView2.layoutManager = linearLayoutManager
        recyclerView2.hasFixedSize()
    }



}
