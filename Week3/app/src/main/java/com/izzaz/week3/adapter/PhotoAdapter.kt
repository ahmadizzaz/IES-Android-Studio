package com.izzaz.week3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izzaz.week3.datamodel.PhotoModel
import com.izzaz.week3.interfaces.ItemClickListener
import com.izzaz.week3.ui.MainActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.izzaz.week3.R
import com.jakewharton.rxbinding.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout2.view.*

class PhotoAdapter(var context: MainActivity, var mPhotoList: ArrayList<PhotoModel>,private val itemClick:ItemClickListener): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(){

    companion object{
        var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return PhotoViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mPhotoList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        mItemClickListener = itemClick
        RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
        return holder.bind(mPhotoList[position])
    }

    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val photoImage: ImageView = itemView.photo
        private val width: TextView = itemView.photo_width
        private val height: TextView = itemView.photo_height
        val mView = view

        private val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        @SuppressLint("SetTextI18n")
        fun bind(photo: PhotoModel){
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(photo.download_url)
                .into(photoImage)
            width.text = "Width : " + photo.width
            height.text = "Height : " + photo.height
        }
    }
}