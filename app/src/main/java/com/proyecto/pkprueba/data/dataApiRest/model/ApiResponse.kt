package com.proyecto.pkprueba.data.dataApiRest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("next") var next: String ?= "",
    @SerializedName("previous") var previous: String ?= "",
    @SerializedName("results") var results: ArrayList<ListadoPokemonResponse>
): Serializable