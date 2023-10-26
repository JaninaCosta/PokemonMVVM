package com.bigproject.appdelivery.interfaz

import com.bigproject.appdelivery.data.dataApiRest.model.ListadoPokemonResponse


interface OnListener {
    fun onSelected(pokemon: ListadoPokemonResponse)
}