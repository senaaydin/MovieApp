package com.sena.movieapp.screen.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.sena.movieapp.R
import com.sena.movieapp.base.view.BaseActivity
import com.sena.movieapp.screen.movie.MovieActivity
import com.sena.movieapp.uimodel.MovieDetailUiModel
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity<MovieDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        with(viewModel) {
            fetchMovieDetails(419704)
        }
    }

    fun initUi(it: MovieDetailUiModel){
        movie_title.text = it.title
        movie_release_date.text = it.releaseDate.toString()
        movie_runtime.text = it.runtime.toString() + " minutes"
        movie_overview.text = it.overview
    }

    companion object{
        fun newIntent(context: Context): Intent = Intent(context, MovieDetailActivity::class.java)
    }
}
