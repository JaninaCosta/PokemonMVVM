package com.bigproject.pkprueba.domain

import com.bigproject.pkprueba.data.dataApiRest.repository.PokemonRepository
import com.bigproject.pkprueba.data.dataApiRest.model.ApiResponse
import com.bigproject.pkprueba.utils.Resource
import javax.inject.Inject

class ObtenerListadoPokemosUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(offset: Int, limit: Int): Resource<ApiResponse>{
        return repository.obtenerListadoPokemon(limit, offset)
    }
}