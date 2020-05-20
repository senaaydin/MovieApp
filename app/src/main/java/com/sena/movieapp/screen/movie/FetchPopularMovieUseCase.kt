package com.sena.movieapp.screen.movie

import com.sena.movieapp.base.model.MovieResponseModel
import com.sena.movieapp.base.usecase.UseCase
import com.sena.movieapp.uimodel.MovieUiModel
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository
) : UseCase<List<MovieResponseModel>, UseCase.None>() {

    override suspend fun buildUseCase(params: None) = repository.fetchPopularMovies()
}