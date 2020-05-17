package com.sena.movieapp.base.model

import com.sena.movieapp.uimodel.MovieUiModel
import com.squareup.moshi.Json
import java.io.Serializable

data class PopularMovieResponseModel(
    @Json(name = "results") val movieList: List<MovieResponseModel>
) :BaseResponseModel()