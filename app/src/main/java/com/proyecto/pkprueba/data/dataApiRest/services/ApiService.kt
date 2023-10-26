package com.proyecto.pkprueba.data.dataApiRest.services

import com.proyecto.pkprueba.interfaz.detalle.DetallePokemonResponse
import com.proyecto.pkprueba.data.dataApiRest.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.Query

/*
    Project: AppDelivery
    Autor: Janina Costa
    Fecha: 11/11/2022
*/

interface ApiService {
    @GET("api/v2/pokemon")
    suspend fun obtenerListadoPokemon(
        @HeaderMap headers: Map<String, String>,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Response<ApiResponse>

    @GET("api/v2/pokemon/{id}")
    suspend fun obtenerDetallePokemon(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int
    ): Response<DetallePokemonResponse>
}