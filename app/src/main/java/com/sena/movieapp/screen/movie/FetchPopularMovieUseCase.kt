package com.sena.movieapp.screen.movie

import com.sena.movieapp.base.model.MovieResponseModel
import com.sena.movieapp.base.usecase.UseCase
import com.sena.movieapp.uimodel.MovieUiModel

class FetchPopularMovieUseCase (private val repository: MovieRepository = MovieRepository()
): UseCase<List<MovieResponseModel>, UseCase.None>() {

    override suspend fun buildUseCase(params: None) = repository.fetchPopularMovies()
}