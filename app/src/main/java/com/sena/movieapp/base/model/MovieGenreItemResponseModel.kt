package com.sena.movieapp.base.model

import com.sena.movieapp.base.datasource.BaseResponseModel
import com.sena.movieapp.uimodel.MovieGenreUiModel
import com.squareup.moshi.Json

data class MovieGenreItemResponseModel(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String
) : BaseResponseModel() {

    fun toUiModel() = MovieGenreUiModel(id = id, name = name)

    fun toCacheModel() = MovieGenreLocalModel(id = id, name = name)
}