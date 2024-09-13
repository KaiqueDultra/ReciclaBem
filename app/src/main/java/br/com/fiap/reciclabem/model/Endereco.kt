package br.com.fiap.reciclabem.model

import com.google.gson.annotations.SerializedName

data class Endereco(
    val results: List<Place>
)

data class Place(
    @SerializedName("place_id") val placeId: String,
    val name: String,
    @SerializedName("vicinity") val address: String,
    val geometry: Geometry
)

data class Geometry(
    val location: Location
)

data class Location(
    val lat: Double,
    val lng: Double
)
