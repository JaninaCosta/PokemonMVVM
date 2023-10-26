package com.proyecto.pkprueba.domain

import com.proyecto.pkprueba.data.dataApiRest.repository.PokemonRepository
import com.proyecto.pkprueba.interfaz.detalle.DetallePokemonResponse
import com.proyecto.pkprueba.utils.Resource
import javax.inject.Inject

class ObtenerDetallePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(id: Int): Resource<DetallePokemonResponse>{
        return repository.obtenerDetallePokemon(id)
    }
}