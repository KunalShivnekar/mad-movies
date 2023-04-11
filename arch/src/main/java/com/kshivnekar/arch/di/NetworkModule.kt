package com.kshivnekar.arch.di

import android.content.Context
import android.content.res.Resources
import com.google.gson.Gson
import com.kshivnekar.arch.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideResource(@ApplicationContext context: Context): Resources = context.resources

    @Provides
    @Singleton
    fun provideOkHttpClient(resources: Resources): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createAuthInterceptor(resources))
            .build()
    }

    private fun createAuthInterceptor(resources: Resources): Interceptor {
        return Interceptor { chain ->
            val updatedUrl = chain.request().url().newBuilder()
                .addQueryParameter("api_key", resources.getString(R.string.api_key))
                .build()
            chain.proceed(
                chain.request().newBuilder()
                    .url(updatedUrl)
                    .build()
            )
        }
    }
}