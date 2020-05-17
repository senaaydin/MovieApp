package com.sena.movieapp.screen.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sena.movieapp.R
import com.sena.movieapp.base.model.MovieResponseModel
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class PopularMovieListAdapter (private val movieList: List<MovieResponseModel>):
    RecyclerView.Adapter<PopularMovieListAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: PopularMovieListAdapter.MovieViewHolder, position: Int) {
        holder.bind(movieList [position])

    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieList: MovieResponseModel){
            itemView.apply {
                text_view_title.text = movieList.title
                text_view_release_date.text = movieList.releaseDate.toString()
                text_view_average.text = movieList.average.toString()
            }
        }
    }

}