package com.bigproject.pkprueba.domain

import com.bigproject.pkprueba.data.dataApiRest.repository.PokemonRepository
import com.bigproject.pkprueba.interfaz.detalle.DetallePokemonResponse
import com.bigproject.pkprueba.utils.Resource
import javax.inject.Inject

class ObtenerDetallePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(id: Int): Resource<DetallePokemonResponse>{
        return repository.obtenerDetallePokemon(id)
    }
}