package com.example.movieapi.models

import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("Search") val search: List<Movie>,
    val totalResults : Int,
    @SerializedName("Response") val response : String
) {
    data class Movie(
        @SerializedName("Title") val title : String,
        @SerializedName("Year") val year : String,
        val imdbID : String,
        @SerializedName("Type") val type : String,
        @SerializedName("Poster") val poster : String
    )
}