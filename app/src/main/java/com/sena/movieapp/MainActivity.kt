package com.sena.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sena.movieapp.screen.detail.MovieDetailActivity
import com.sena.movieapp.screen.employee.EmployeeActivity
import com.sena.movieapp.screen.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity_main_open_button.setOnClickListener {
            startActivity(EmployeeActivity.newIntent(this))
        }
        activity_main_detail_button.setOnClickListener {
            startActivity(MovieDetailActivity.newIntent(this))
        }
    }
}
