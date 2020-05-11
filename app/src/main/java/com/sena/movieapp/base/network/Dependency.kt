package com.sena.movieapp.base.network

import com.sena.movieapp.base.network.KeyStore.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Dependency {

    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()
    }

    private val okHttpClient: OkHttpClient by lazy { OkHttpClient.Builder().build() }

    private val repository: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory { okHttpClient.newCall(it) }
            .build()
    }
}