package com.kshivnekar.moviesdata.repository

import com.kshivnekar.arch.data.Response
import com.kshivnekar.moviesdata.remote.APISimilarFilm
import com.kshivnekar.moviesdata.remote.ApiFilm
import com.kshivnekar.moviesdata.remote.Genre

interface MovieRepository {
    suspend fun fetchTopRated(): Response<List<ApiFilm>>
    suspend fun fetchMovie(id: Long): Response<ApiFilm>
    suspend fun fetchSimilar(id: Long): Response<List<APISimilarFilm>>
    suspend fun fetchGenres(): Response<HashMap<Int, Genre>>
}