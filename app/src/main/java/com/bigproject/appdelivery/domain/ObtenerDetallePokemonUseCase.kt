package com.bigproject.appdelivery.domain

import com.bigproject.appdelivery.data.dataApiRest.repository.PokemonRepository
import com.bigproject.appdelivery.interfaz.detalle.DetallePokemonResponse
import com.bigproject.appdelivery.utils.Resource
import javax.inject.Inject

class ObtenerDetallePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(id: Int): Resource<DetallePokemonResponse>{
        return repository.obtenerDetallePokemon(id)
    }
}