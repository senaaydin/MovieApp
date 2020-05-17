package com.sena.movieapp.screen.movie

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sena.movieapp.R
import com.sena.movieapp.base.model.MovieResponseModel
import com.sena.movieapp.base.view.BaseActivity
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity<MovieViewModel> (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        observeData()
        viewModel.fetchPopularMovies()
    }

    fun observeData(){
        viewModel.popularMovies.observe(this, Observer {
            initRecyclerView(it)
        })
    }

    fun initRecyclerView(itemList: List<MovieResponseModel>){
        val popularMovieListAdapter = PopularMovieListAdapter(itemList)
        val layoutManager =  LinearLayoutManager(this)
        movie_recyclerview.layoutManager = layoutManager
        movie_recyclerview.adapter = popularMovieListAdapter
    }

    companion object{
        fun newIntent(context: Context): Intent = Intent(context, MovieActivity::class.java)
    }
}
