package com.sena.movieapp.base.datasource

import android.content.SharedPreferences
import com.sena.movieapp.base.model.MovieGenreLocalModel
import com.squareup.moshi.Moshi

class MovieLocalDataSource  constructor(
    sharedPreferences: SharedPreferences,
    moshi: Moshi
) {



    fun fetchGenres(): List<MovieGenreLocalModel>? {
        return null
    }

    fun insertGenres(genreList: List<MovieGenreLocalModel>?) {

    }

    companion object {
        private const val PREF_GENRES = "movie_genres"
    }
}
