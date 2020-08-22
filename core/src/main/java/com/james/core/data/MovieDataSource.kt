package com.james.core.data

import com.james.core.model.Movie

interface MovieDataSource {
    suspend fun searchMovieByTitle(term: String): List<Movie>
    suspend fun getMovieById(id: String): Movie
}