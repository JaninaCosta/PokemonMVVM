package com.bigproject.pkprueba.data.dataApiRest.services

import com.bigproject.pkprueba.data.dataApiRest.api.RecursoApi
import com.bigproject.pkprueba.data.dataApiRest.model.ApiResponse
import com.bigproject.pkprueba.interfaz.detalle.DetallePokemonResponse
import com.bigproject.pkprueba.utils.Resource
import javax.inject.Inject

class PokemonService @Inject constructor() {
    val apiService = RETROFIT_DELIVERY.settingService()

    suspend fun getListadoPokemon(offset: Int, limit: Int): Resource<ApiResponse> {
        return RecursoApi.safeConsumeApi {
            apiService.obtenerListadoPokemon(
                RETROFIT_DELIVERY.headersJsonWithAuthentication,
                limit,
                offset
            )
        }
    }
    suspend fun getDetallePokemon(id: Int): Resource<DetallePokemonResponse> {
        return RecursoApi.safeConsumeApi {
            apiService.obtenerDetallePokemon(
                RETROFIT_DELIVERY.headersJsonWithAuthentication,
                id
            )
        }
    }
}