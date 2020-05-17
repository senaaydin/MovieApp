package com.sena.movieapp.screen.movie

import com.sena.movieapp.base.datasource.BaseRemoteDataSource
import com.sena.movieapp.base.model.MovieDetailResponseModel
import com.sena.movieapp.base.model.MovieGenreResponseModel
import com.sena.movieapp.base.model.PopularMovieResponseModel

class MovieRemoteDataSource constructor(private val service: MovieService): BaseRemoteDataSource() {

    suspend fun fetchPopularMovies(): PopularMovieResponseModel = service.fetchPopularMovies()

    suspend fun fetchMovieGenres(): MovieGenreResponseModel = invoke {
        service.fetchMovieGenres()
    }


    suspend fun fetchMovieDetail(id: Long): MovieDetailResponseModel = invoke {
        service.fetchMovieDetail(id)
    }

}