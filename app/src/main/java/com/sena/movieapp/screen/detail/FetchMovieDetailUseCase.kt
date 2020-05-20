package com.sena.movieapp.screen.detail

import com.sena.movieapp.base.usecase.UseCase
import com.sena.movieapp.screen.movie.MovieRepository
import com.sena.movieapp.uimodel.MovieDetailUiModel
import javax.inject.Inject

class FetchMovieDetailUseCase @Inject constructor(private val repository: MovieRepository = MovieRepository()) :
    UseCase<MovieDetailUiModel, FetchMovieDetailUseCase.Params>() {

    override suspend fun buildUseCase(params: Params) = repository.fetchMovieDetail(params.id)

    data class Params(val id: Long)
}