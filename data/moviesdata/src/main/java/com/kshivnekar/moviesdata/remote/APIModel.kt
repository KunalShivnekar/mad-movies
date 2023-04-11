package com.kshivnekar.moviesdata.remote

import com.google.gson.annotations.SerializedName

data class ApiFilmListResponse(val results: List<ApiFilm>)

data class ApiFilm(
    val id: Long,
    val title: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("vote_average") val voteAverage: String?
)
data class APISimilarFilmListResponse(val results: List<APISimilarFilm>)

data class APISimilarFilm(
    val id: Long,
    val title: String,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("vote_average") val voteAverage: String?
)

data class GenreListResponse(val genres: List<Genre>)

data class Genre(val id: Int, val name: String)