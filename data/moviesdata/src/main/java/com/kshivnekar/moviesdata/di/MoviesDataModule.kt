package com.kshivnekar.moviesdata.di

import com.google.gson.Gson
import com.kshivnekar.moviesdata.remote.MovieService
import com.kshivnekar.moviesdata.remote.RemoteDataSource
import com.kshivnekar.moviesdata.remote.RemoteDataSourceImpl
import com.kshivnekar.moviesdata.repository.MovieRepository
import com.kshivnekar.moviesdata.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
internal class MoviesDataModule {

    @Provides
    fun provideMovieService(client: OkHttpClient): MovieService {
        return Retrofit.Builder()
            .baseUrl(MovieService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(client)
            .build()
            .create(MovieService::class.java)
    }

    @Provides
    fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource{
        return remoteDataSourceImpl
    }

    @Provides
    fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl):MovieRepository{
        return movieRepositoryImpl
    }

}