package com.proyecto.pkprueba.interfaz

import com.proyecto.pkprueba.data.dataApiRest.model.ListadoPokemonResponse


interface OnListener {
    fun onSelected(pokemon: ListadoPokemonResponse)
}