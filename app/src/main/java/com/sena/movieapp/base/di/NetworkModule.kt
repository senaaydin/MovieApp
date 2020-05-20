package com.sena.movieapp.base.di

import com.sena.movieapp.BuildConfig
import com.sena.movieapp.base.network.Dependency
import com.sena.movieapp.base.network.KeyStore
import com.sena.movieapp.screen.employee.EmployeeService
import com.sena.movieapp.screen.movie.MovieService
import com.squareup.moshi.Moshi
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideNetworkService(): EmployeeService = Dependency.repository.create(EmployeeService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(client: Lazy<OkHttpClient>, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(KeyStore.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory { client.get().newCall(it) }
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}