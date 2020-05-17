package com.sena.movieapp.screen.movie

import com.sena.movieapp.base.model.MovieDetailResponseModel
import com.sena.movieapp.base.model.MovieGenreResponseModel
import com.sena.movieapp.base.model.PopularMovieResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET(POPULAR)
    suspend fun fetchPopularMovies(): PopularMovieResponseModel

    @GET(GENRE)
    suspend fun fetchMovieGenres(): MovieGenreResponseModel

    @GET(DETAIL)
    suspend fun fetchMovieDetail(@Path(PATH_MOVIE_ID) id: Long): MovieDetailResponseModel

    companion object {
        const val POPULAR = "movie/popular"
        const val GENRE = "genre/movie/list"
        const val NOW_PLAYING = "movie/now_playing"
        const val PATH_MOVIE_ID = "movie_id"
        const val DETAIL = "movie/{$PATH_MOVIE_ID}"
        const val CREDIT = "movie/{$PATH_MOVIE_ID}/credits"
    }
}