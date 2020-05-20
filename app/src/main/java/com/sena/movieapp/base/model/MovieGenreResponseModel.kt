package com.sena.movieapp.base.model

import com.sena.movieapp.base.datasource.BaseResponseModel
import com.squareup.moshi.Json

data class MovieGenreResponseModel(
    @Json(name = "genres") val genres: List<MovieGenreItemResponseModel>
) : BaseResponseModel()