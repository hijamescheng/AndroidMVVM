package com.james.core.data

import com.james.core.model.Movie

interface MovieRepository {
    fun searchMovieByTitle(term: String): List<Movie>
    fun getMovieById(id: String): Movie
}