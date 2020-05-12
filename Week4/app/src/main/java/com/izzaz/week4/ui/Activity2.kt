package com.izzaz.week4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.izzaz.week4.R
import com.izzaz.week4.adapter.TypeAdapter
import com.izzaz.week4.datamodel.Pokemon
import kotlinx.android.synthetic.main.activity2.*
import kotlinx.android.synthetic.main.activity_main.*


class Activity2 : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

       val  pokemon = intent.extras?.get("Pokemon") as Pokemon
        setDataFields(pokemon)
    }

    private fun setDataFields(pokemon: Pokemon) {
        pokemonName_tv.text = pokemon.name
        nationalID_tv.text = pokemon.national_no.toString()
        species_tv.text = pokemon.species
        height_tv.text = pokemon.height
        weight_tv.text = pokemon.weight
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        Glide.with(this)
            .applyDefaultRequestOptions(requestOptions)
            .load(pokemon.image)
            .into(pokemon_pic)

        recyclerView2.adapter = TypeAdapter(this,pokemon.type as ArrayList<String>)
        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.layoutManager = linearLayoutManager
    }
}