package com.example.movies.interactor

import androidx.lifecycle.LiveData
import com.example.movies.model.Movie

interface MoviesRepo {
    fun getMovies(): LiveData<List<Movie>>
    fun saveNewMovie(movie: Movie)
}