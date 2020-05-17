package com.sena.movieapp.screen.movie

import com.sena.movieapp.base.datasource.MovieLocalDataSource
import com.sena.movieapp.base.model.MovieResponseModel
import com.sena.movieapp.base.network.Dependency.movieService
import com.sena.movieapp.uimodel.MovieGenreUiModel
import com.sena.movieapp.uimodel.MovieUiModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class MovieRepository (
    private val remoteDataSource: MovieRemoteDataSource = MovieRemoteDataSource(movieService)
){
    suspend fun fetchPopularMovies(): List<MovieResponseModel> {
        return remoteDataSource.fetchPopularMovies().movieList
    }

    suspend fun fetchMovieDetail(id: Long) = remoteDataSource.fetchMovieDetail(id).toUiModel()

}