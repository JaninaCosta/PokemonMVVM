package com.bigproject.pkprueba.interfaz

import com.bigproject.pkprueba.data.dataApiRest.model.ListadoPokemonResponse


interface OnListener {
    fun onSelected(pokemon: ListadoPokemonResponse)
}