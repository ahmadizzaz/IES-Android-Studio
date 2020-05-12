package com.izzaz.week4.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.izzaz.week4.R
import com.izzaz.week4.adapter.PokemonAdapter
import com.izzaz.week4.datamodel.Pokemon
import com.izzaz.week4.interfaces.ItemClickListener
import com.izzaz.week4.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var mPokemonViewModel: PokemonViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this,Activity2::class.java)
        setViewLayouts()
        getPokemonList(intent)
    }

    private fun setViewLayouts(){
        val pokeApiImage: ImageView = pokeApi_image
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        Glide.with(this)
            .applyDefaultRequestOptions(requestOptions)
            .load("https://raw.githubusercontent.com/PokeAPI/media/master/logo/pokeapi_256.png")
            .into(pokeApiImage)
        gridLayoutManager = GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.hasFixedSize()
    }

    private fun getPokemonList(intent: Intent){
        mPokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        mPokemonViewModel.getPokemonData()?.observe(this, Observer<List<Pokemon>> { pokeList ->
            recyclerView.adapter = PokemonAdapter(this,pokeList as ArrayList<Pokemon>,object : ItemClickListener{
                override fun onItemClick(pokemon: Pokemon) {
                    intent.putExtra("Pokemon", pokemon as Serializable)
                    startActivity(intent)
                }
            })
        })
    }

}
