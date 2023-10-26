package com.bigproject.appdelivery.data.dataApiRest.repository

import com.bigproject.appdelivery.data.dataApiRest.model.ApiResponse
import com.bigproject.appdelivery.data.dataApiRest.services.PokemonService
import com.bigproject.appdelivery.interfaz.detalle.DetallePokemonResponse
import com.bigproject.appdelivery.utils.Resource
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