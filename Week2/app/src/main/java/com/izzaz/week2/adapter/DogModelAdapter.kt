package com.izzaz.week2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.izzaz.week2.R
import com.izzaz.week2.model.DogModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dog_item.view.*

class DogModelAdapter(private val dog:List<DogModel>) : RecyclerView.Adapter<DogModelAdapter.DogModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item,parent,false)
        return DogModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogModelViewHolder, position: Int) {
        val currentItem = dog[position]
        holder.bindItems(dog[position])
    }

    override fun getItemCount(): Int {
        return dog.size
    }

     class DogModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val dogImage: ImageView = itemView.imageView2
         val dogNameTV: TextView = itemView.dogName
         val dogBreedTV: TextView = itemView.dogBreed

         fun bindItems(model:DogModel){
             dogNameTV.text = model.name
             dogBreedTV.text = model.breed

             val requestOptions = RequestOptions()
                 .placeholder(R.drawable.ic_launcher_background)
                 .error(R.drawable.ic_launcher_background)

             Glide.with(itemView.context)
                 .applyDefaultRequestOptions(requestOptions)
                 .load(model.url)
                 .into(dogImage)
         }
    }
}