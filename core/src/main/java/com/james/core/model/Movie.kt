package com.james.core.model

import java.util.Date

data class Movie(
    val title: String?,
    val year: String?,
    val rated: String?,
    val released: Date?,
    val runtime: String?,
    val genre: String?,
    val director: String?,
    val writer: String?,
    val actors: String?,
    val plot: String?,
    val language: String?,
    val country: String?,
    val awards: String?,
    val poster: String?,
    val ratings: List<Rating>?,
    val metaScore: Int?,
    val imdbRating: Float?,
    val imdbVotes: String?,
    val imdbID: String?,
    val type: String?,
    val dvd: Date?,
    val boxOffice: Date?,
    val production: String?,
    val website: String?,
    val response: Boolean
)