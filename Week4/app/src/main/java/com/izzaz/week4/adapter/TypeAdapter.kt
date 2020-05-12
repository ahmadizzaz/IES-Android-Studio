package com.izzaz.week4.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.izzaz.week4.R
import com.izzaz.week4.ui.Activity2
import com.izzaz.week4.ui.MainActivity
import kotlinx.android.synthetic.main.type_layout.view.*

class TypeAdapter(var context: Activity2, var typeList: ArrayList<String>): RecyclerView.Adapter<TypeAdapter.TypeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.type_layout, parent, false)
        return TypeViewHolder(view)

    }

    override fun getItemCount(): Int {
        return typeList.size
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {

        return holder.bind(typeList[position])
    }

    class TypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val typeName: TextView = itemView.typeName
        private val bgColour: CardView = itemView.cardView
        fun bind(type: String){
            if (type == "Grass") {
                bgColour.setCardBackgroundColor(Color.parseColor("#78C850"))
            }else if(type == "Fire"){
                bgColour.setCardBackgroundColor(Color.parseColor("#F08030"))
            }else if(type == "Water"){
                bgColour.setCardBackgroundColor(Color.parseColor("#6890F0"))
            }else if(type == "Ghost"){
                bgColour.setCardBackgroundColor(Color.parseColor("#705898"))
            }else if(type == "Poison"){
                bgColour.setCardBackgroundColor(Color.parseColor("#A040A0"))
            }else if(type == "Flying"){
                bgColour.setCardBackgroundColor(Color.parseColor("#98D8D8"))
            }
            typeName.text = type
        }
    }
}