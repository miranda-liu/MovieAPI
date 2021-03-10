package com.example.movieapi.services

import com.example.movieapi.models.MovieResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET(".")
    fun getMoviesList (@Query("apiKey") apiKey : String, @Query("s") search : String) : Call<MovieResult>
}