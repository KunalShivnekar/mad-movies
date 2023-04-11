package com.kshivnekar.moviesdata.repository

import com.kshivnekar.arch.data.Response
import com.kshivnekar.moviesdata.remote.*
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):MovieRepository {

    override suspend fun fetchTopRated(): Response<List<ApiFilm>> {
        return remoteDataSource.fetchTopRated()
    }

    override suspend fun fetchMovie(id: Long): Response<ApiFilm> {
        return remoteDataSource.fetchMovie(id)
    }

    override suspend fun fetchSimilar(id: Long): Response<List<APISimilarFilm>> {
        return remoteDataSource.fetchSimilar(id)
    }

    override suspend fun fetchGenres(): Response<HashMap<Int, Genre>> {
        return remoteDataSource.fetchGenres()
    }
}