package com.izzaz.week2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izzaz.week2.model.FoodItem
import com.izzaz.week2.R
import kotlinx.android.synthetic.main.food_item.view.*

class FoodItemAdapter(private val food:List<FoodItem>) : RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
        return FoodItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        val currentItem = food[position]
        holder.itemTV.text = currentItem.food

    }

    override fun getItemCount(): Int {
        return food.size
    }

     class FoodItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val itemTV: TextView = itemView.itemTextView
    }
}