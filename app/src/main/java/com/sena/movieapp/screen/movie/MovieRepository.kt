package com.sena.movieapp.screen.movie

import com.sena.movieapp.base.datasource.MovieLocalDataSource
import com.sena.movieapp.base.model.MovieResponseModel
import com.sena.movieapp.base.network.Dependency.movieService

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource = MovieRemoteDataSource(movieService)
){
    suspend fun fetchPopularMovies(): List<MovieResponseModel> {
        return remoteDataSource.fetchPopularMovies().movieList
    }

    suspend fun fetchMovieDetail(id: Long) = remoteDataSource.fetchMovieDetail(id).toUiModel()

}