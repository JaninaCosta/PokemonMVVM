package com.proyecto.pkprueba.domain

import com.proyecto.pkprueba.data.dataApiRest.repository.PokemonRepository
import com.proyecto.pkprueba.data.dataApiRest.model.ApiResponse
import com.proyecto.pkprueba.utils.Resource
import javax.inject.Inject

class ObtenerListadoPokemosUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(offset: Int, limit: Int): Resource<ApiResponse>{
        return repository.obtenerListadoPokemon(limit, offset)
    }
}