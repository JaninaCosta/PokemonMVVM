package com.proyecto.pkprueba.data.dataApiRest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListadoPokemonResponse(
    @SerializedName("name") var name: String,
    @SerializedName("url") var url: String,
    var image: String
): Serializable