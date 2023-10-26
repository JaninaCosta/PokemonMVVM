package com.proyecto.pkprueba.data.dataApiRest.repository

import com.proyecto.pkprueba.data.dataApiRest.model.ApiResponse
import com.proyecto.pkprueba.data.dataApiRest.services.PokemonService
import com.proyecto.pkprueba.interfaz.detalle.DetallePokemonResponse
import com.proyecto.pkprueba.utils.Resource
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonService
) {
    suspend fun obtenerListadoPokemon(offset: Int, limit: Int): Resource<ApiResponse> {
        return api.getListadoPokemon(limit, offset)
    }


    suspend fun obtenerDetallePokemon(id: Int): Resource<DetallePokemonResponse> {
        return api.getDetallePokemon(id)
    }
}