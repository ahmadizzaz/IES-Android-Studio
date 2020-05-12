package com.izzaz.week3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izzaz.week3.interfaces.ItemClickListener
import com.izzaz.week3.ui.MainActivity
import com.izzaz.week3.R
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.item_layout2.view.*

class AuthorAdapter(var context: MainActivity, var mAuthorList: ArrayList<String>?,private val itemClick:ItemClickListener): RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>(){

    companion object{
        var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout2, parent, false)
        return AuthorViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mAuthorList!!.size
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        mItemClickListener = itemClick
        val subscribe = RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
        return holder.bind(this.mAuthorList!![position])
    }

    class AuthorViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val author: TextView = itemView.author_tv
        val mView = view

        @SuppressLint("SetTextI18n")
        fun bind(data : String){
            author.text = data
        }
    }
}