package com.izzaz.week4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.izzaz.week4.R
import com.izzaz.week4.datamodel.Pokemon
import com.izzaz.week4.interfaces.ItemClickListener
import com.izzaz.week4.ui.MainActivity
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.item_layout.view.*

class PokemonAdapter(var context: MainActivity,var pokemonList: ArrayList<Pokemon>,private val itemClick:ItemClickListener): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>(){

    companion object{
        var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        mItemClickListener = itemClick
        RxView.clicks(holder.mView).subscribe{
            mItemClickListener!!.onItemClick(pokemonList[position])
        }
        return holder.bind(pokemonList[position])
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mView = view
        private val pokeImage: ImageView = itemView.pokemonPhoto
        private val pokeName: TextView = itemView.pokemon_name
        private val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        fun bind(poke: Pokemon){
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(poke.image)
                .into(pokeImage)
            pokeName.text = poke.name
        }
    }
}