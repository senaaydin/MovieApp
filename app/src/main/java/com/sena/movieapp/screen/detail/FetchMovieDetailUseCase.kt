package com.sena.movieapp.screen.detail

import com.sena.movieapp.base.usecase.UseCase
import com.sena.movieapp.screen.movie.MovieRepository
import com.sena.movieapp.uimodel.MovieDetailUiModel

class FetchMovieDetailUseCase(private val repository: MovieRepository) : UseCase<MovieDetailUiModel, FetchMovieDetailUseCase.Params>() {

    override suspend fun buildUseCase(params: Params) = repository.fetchMovieDetail(params.id)

    data class Params(val id: Long)
}