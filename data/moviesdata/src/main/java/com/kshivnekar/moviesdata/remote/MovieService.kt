package com.kshivnekar.moviesdata.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/top_rated")
    suspend fun topRated(): Response<ApiFilmListResponse>

    @GET("movie/{movie_id}")
    suspend fun movie(@Path("movie_id") movieId: Long): Response<ApiFilm>

    @GET("movie/{movie_id}/similar")
    suspend fun similar(@Path("movie_id") movieId: Long): Response<APISimilarFilmListResponse>

    @GET("genre/movie/list")
    suspend fun genres(): Response<GenreListResponse>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY_PARAM = "api_key"

        fun buildImageUrl(path: String) = "https://image.tmdb.org/t/p/w500$path"
    }

}