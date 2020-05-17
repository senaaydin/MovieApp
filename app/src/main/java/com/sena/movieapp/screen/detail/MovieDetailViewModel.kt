package com.sena.movieapp.screen.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sena.movieapp.base.viewmodel.BaseAndroidViewModel
import com.sena.movieapp.uimodel.MovieDetailUiModel
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
    //private val fetchMovieCreditsUseCase: FetchMovieCreditsUseCase,
    application: Application
) : BaseAndroidViewModel(application) {

    private val _movieDetails = MutableLiveData<MovieDetailUiModel>()
    //private val _movieCredits = MutableLiveData<MovieCreditUiModel>()
    val movieDetails: LiveData<MovieDetailUiModel> get() = _movieDetails
    //val movieCredits: LiveData<MovieCreditUiModel> get() = _movieCredits

    fun fetchMovieDetails(id: Long) {
        if (_movieDetails.value == null) {
            viewModelScope.launch {
                val movieDetailResult =
                    fetchMovieDetailUseCase.run(FetchMovieDetailUseCase.Params(id))
                movieDetailResult.either(::handleFailure, ::postMovieDetail)
            }
        }
    }

    private fun postMovieDetail(movieDetailUiModel: MovieDetailUiModel) {
        _movieDetails.value = movieDetailUiModel
    }

}