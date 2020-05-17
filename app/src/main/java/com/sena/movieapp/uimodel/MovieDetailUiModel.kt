package com.sena.movieapp.uimodel

import java.io.Serializable
import java.util.*

data class MovieDetailUiModel(
    override val id: Long,
    override val title: String,
    override val overview: String,
     val genres: List<GenreUiModel>,
    override val posterPath: String?,
    override val average: Double,
    override val runtime: Int?,
    override val releaseDate: Date?,
    val popularity: Double
) : ShowDetailUiModel, Serializable