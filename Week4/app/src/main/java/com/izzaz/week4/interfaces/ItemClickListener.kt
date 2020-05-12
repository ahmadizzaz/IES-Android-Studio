package com.izzaz.week4.interfaces

import com.izzaz.week4.datamodel.Pokemon

interface ItemClickListener {
    fun onItemClick(pokemon : Pokemon)
}