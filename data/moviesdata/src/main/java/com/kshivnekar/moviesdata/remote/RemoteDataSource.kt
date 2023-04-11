package com.kshivnekar.moviesdata.remote

import com.kshivnekar.arch.data.Response

interface RemoteDataSource {
    suspend fun fetchTopRated(): Response<List<ApiFilm>>
    suspend fun fetchMovie(id: Long): Response<ApiFilm>
    suspend fun fetchSimilar(id: Long): Response<List<APISimilarFilm>>
    suspend fun fetchGenres(): Response<HashMap<Int, Genre>>
}