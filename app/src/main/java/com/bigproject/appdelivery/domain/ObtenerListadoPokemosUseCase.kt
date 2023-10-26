package com.bigproject.appdelivery.domain

import com.bigproject.appdelivery.data.dataApiRest.repository.PokemonRepository
import com.bigproject.appdelivery.data.dataApiRest.model.ApiResponse
import com.bigproject.appdelivery.utils.Resource
import javax.inject.Inject

class ObtenerListadoPokemosUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(offset: Int, limit: Int): Resource<ApiResponse>{
        return repository.obtenerListadoPokemon(limit, offset)
    }
}