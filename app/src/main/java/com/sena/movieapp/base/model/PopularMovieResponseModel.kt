package com.sena.movieapp.base.model

import com.sena.movieapp.base.datasource.BaseResponseModel
import com.squareup.moshi.Json

data class PopularMovieResponseModel(
    @Json(name = "results") val movieList: List<MovieResponseModel>
) : BaseResponseModel()