package com.example.movies.viewmodel

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.R
import com.example.movies.model.Movie
import com.example.movies.interactor.MoviesRepo

class MainViewModel( private val moviesRepo: MoviesRepo) : ViewModel(){

    private val movieList = MutableLiveData<List<Movie>>()


    /**
     * Movies
     */
    val edtTitle = MutableLiveData<String>()
    val edtPoster = MutableLiveData<String>()
    val edtYear = MutableLiveData<String>()
    val edtGenre = MutableLiveData<String>()
    val groupDataMovie = MutableLiveData<Movie>()
    var dataMovie = Movie("", "","","")

    fun getMovies() : LiveData<List<Movie>>{
        return moviesRepo.getMovies()
    }

    fun saveNewMovie(title: String, genre: String, year: String, poster: String){
        moviesRepo.saveNewMovie(Movie(title,genre,year,poster))
    }

    fun fieldTextChanged(charSequence: CharSequence, idField: Int) {
        when (idField) {

            ///////Login
            R.id.tv_title -> {
                edtTitle.value = charSequence.toString()
                dataMovie.title = charSequence.toString()
                groupDataMovie.value = dataMovie
            }
            R.id.tv_poster -> {
                edtPoster.value = charSequence.toString()
                dataMovie.genre = charSequence.toString()
                groupDataMovie.value = dataMovie
            }

            R.id.tv_year -> {
                edtYear.value = charSequence.toString()
                dataMovie.year = charSequence.toString()
                groupDataMovie.value = dataMovie
            }

            R.id.tv_genre -> {
                edtGenre.value = charSequence.toString()
                dataMovie.genre = charSequence.toString()
                groupDataMovie.value = dataMovie
            }
        }
    }

}