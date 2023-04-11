package com.kshivnekar.moviesdata.remote

import com.kshivnekar.arch.data.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val movieService: MovieService):RemoteDataSource {

    override suspend fun fetchTopRated(): Response<List<ApiFilm>> {
        val response = movieService.topRated()
        if (response.isSuccessful.not())
            return Response.Error(Exception(response.message()))

        return Response.Success(response.body()!!.results)
    }

    override suspend fun fetchMovie(id: Long): Response<ApiFilm> {
        val response = movieService.movie(id)
        if (response.isSuccessful.not())
            return Response.Error(Exception(response.message()))

        return Response.Success(response.body()!!)
    }

    override suspend fun fetchSimilar(id: Long): Response<List<APISimilarFilm>> {
        val response = movieService.similar(id)
        if (response.isSuccessful.not())
            return Response.Error(Exception(response.message()))

        return Response.Success(response.body()!!.results)
    }

    override suspend fun fetchGenres(): Response<HashMap<Int, Genre>> {
        val genreMap = hashMapOf<Int, Genre>()
        val response = movieService.genres()
        if (response.isSuccessful.not())
            return Response.Error(Exception(response.message()))
        val genresList = response.body()!!.genres
        for (genre in genresList) {
            genreMap[genre.id] = genre
        }
        return Response.Success(genreMap)
    }
}