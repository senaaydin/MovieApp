package com.sena.movieapp.uimodel

import com.sena.movieapp.base.ListAdapterItem
import java.io.Serializable
import java.util.*

interface ShowUiModel : ListAdapterItem, Serializable {
    override val id: Long

    val title: String

    val overview: String

    //val genres: List<GenreUiModel>

    val posterPath: String?

    val average: Double

    val releaseDate: Date?

    val averageString: String get() = average.toString()

//    val releaseDateString: String
//        get() = releaseDate?.formatDate(DATE_FORMAT_SHOW) ?: ""

//    val genreString: String
//        get() = genres.joinToString(separator = ", ", limit = 3, truncated = "") { it.name }

    companion object {
        const val DATE_FORMAT_SHOW = "dd.MM.yyyy"
    }
}