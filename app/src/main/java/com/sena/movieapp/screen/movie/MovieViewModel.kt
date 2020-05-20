package com.sena.movieapp.screen.movie

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sena.movieapp.base.model.MovieResponseModel
import com.sena.movieapp.base.usecase.UseCase
import com.sena.movieapp.base.viewmodel.BaseAndroidViewModel
import com.sena.movieapp.uimodel.MovieUiModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase,
    //private val fetchNowPlayingMoviesUseCase: FetchNowPlayingMoviesUseCase,
    application: Application
) : BaseAndroidViewModel(application) {

     val popularMovies = MutableLiveData<List<MovieResponseModel>>()

     fun fetchPopularMovies() {
        viewModelScope.launch {
            val response = fetchPopularMoviesUseCase.run(UseCase.None)
            response.either(::handleFailure, ::postPopularMovieList)

        }
    }

    private fun postPopularMovieList(movies: List<MovieResponseModel>) {
        popularMovies.value = movies

    }

}
