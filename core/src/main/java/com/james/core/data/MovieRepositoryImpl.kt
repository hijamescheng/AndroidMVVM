package com.james.core.data

import com.james.core.model.Movie

class MovieRepositoryImpl constructor(
    private val removeMovieDataSource: MovieDataSource
): MovieRepository {

    override fun searchMovieByTitle(term: String): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getMovieById(id: String): Movie {
        TODO("Not yet implemented")
    }
}