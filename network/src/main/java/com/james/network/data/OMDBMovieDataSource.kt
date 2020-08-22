package com.james.network.data

import com.james.core.data.MovieDataSource
import com.james.core.model.Movie
import com.james.network.service.MovieService

class OMDBMovieDataSource constructor(
    private val movieService: MovieService
): MovieDataSource {

    override suspend fun searchMovieByTitle(term: String) = movieService.searchMovieByTitle(term)

    override suspend fun getMovieById(id: String): Movie = movieService.getMovieById(id)
}