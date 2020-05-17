package com.sena.movieapp.uimodel

import com.sena.movieapp.base.ListAdapterItem
import java.util.*

data class MovieUiModel(
    override val id: Long,
    override val title: String,
    override val overview: String,
    val genres: List<MovieGenreUiModel>,
    override val posterPath: String?,
    override val average: Double,
    override val releaseDate: Date?,
    val backdropPath: String?,
    val popularity: Double,
    val isAdult: Boolean
) : ShowUiModel, ListAdapterItem