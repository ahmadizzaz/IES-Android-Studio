package com.izzaz.week4.datamodel

import java.io.Serializable

data class Pokemon(
    val id : Int,
    val name: String,
    val type: List<String>,
    val species : String,
    val height : String,
    val weight : String,
    val national_no : Int,
    val image : String
) : Serializable