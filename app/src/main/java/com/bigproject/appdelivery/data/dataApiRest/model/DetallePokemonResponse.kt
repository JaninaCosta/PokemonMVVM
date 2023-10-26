package com.bigproject.appdelivery.interfaz.detalle

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetallePokemonResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("forms") var forms: ArrayList<FormsModel>,
    @SerializedName("sprites") var sprites: SpritesModel,
    @SerializedName("weight") var weight: Double,
    @SerializedName("types") var types: ArrayList<TypesModel>,
    @SerializedName("abilities") var abilities: ArrayList<AbilityModel>,
    @SerializedName("moves") var moves: ArrayList<MovesModel>
): Serializable

//nombre
data class FormsModel(
    @SerializedName("name") var name: String
): Serializable


//imagen
data class SpritesModel(
    @SerializedName("front_default") var front_default: String
): Serializable


//tipos
data class TypesModel(
    @SerializedName("type") var type: TypePokemon
): Serializable

data class TypePokemon(
    @SerializedName("name") var name: String
): Serializable

//habilidades
data class AbilityModel(
    @SerializedName("ability") var ability: AbilityPokemon
): Serializable

data class AbilityPokemon(
    @SerializedName("name") var name: String
): Serializable

//movimientos
data class MovesModel(
    @SerializedName("move") var move: MovesPokemon
): Serializable

data class MovesPokemon(
    @SerializedName("name") var name: String
): Serializable