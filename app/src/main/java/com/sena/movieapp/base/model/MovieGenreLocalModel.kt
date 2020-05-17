package com.sena.movieapp.base.model

import com.sena.movieapp.base.datasource.BaseLocalModel
import com.sena.movieapp.uimodel.MovieGenreUiModel

data class MovieGenreLocalModel(
    val id: Long,
    val name: String
) : BaseLocalModel() {

    fun toUiModel() = MovieGenreUiModel(id = id, name = name)
}
