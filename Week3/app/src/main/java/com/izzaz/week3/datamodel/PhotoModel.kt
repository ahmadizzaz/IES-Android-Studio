package com.izzaz.week3.datamodel

data class PhotoModel(
    val id : Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
)