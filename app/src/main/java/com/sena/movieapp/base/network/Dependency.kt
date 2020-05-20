package com.sena.movieapp.base.network

import com.sena.movieapp.base.network.KeyStore.API_KEY
import com.sena.movieapp.base.network.KeyStore.BASE_URL
import com.sena.movieapp.screen.employee.EmployeeService
import com.sena.movieapp.screen.movie.MovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Dependency {

    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()
    }

    val requestInterceptor = Interceptor { chain ->

        val url = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)   //explicitly return a value from whit @ annotation. lambda always returns the value of the last expression implicitly
    }
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

   // private val okHttpClient: OkHttpClient by lazy { OkHttpClient.Builder().build() }

    val repository: Retrofit by lazy {
        Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory { okHttpClient.newCall(it) }
            .build()
    }


    val movieService: MovieService by lazy {
        repository.create(MovieService::class.java)
    }

    val employeeService: EmployeeService by lazy {
        repository.create(EmployeeService::class.java)
    }
}