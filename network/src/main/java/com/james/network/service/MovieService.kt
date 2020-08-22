package com.james.network.service

import com.james.core.model.Movie
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/")
    suspend fun searchMovieByTitle(@Path("t") title: String): List<Movie>

    @GET("/")
    suspend fun getMovieById(@Path("i") id: String): Movie
}