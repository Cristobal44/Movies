package com.example.movies.interactor.implement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movies.interactor.MoviesRepo
import com.example.movies.model.Movie

class MovieRepoImplement : MoviesRepo {

    private val movieList = MutableLiveData<List<Movie>> (
        mutableListOf(
            Movie("Eso","Terror","2000","https://www.sanborns.com.mx/imagenes-sanborns-ii/1200/9786073156615.jpg"),
            Movie("Pinocho","Terror","2000","https://www.sanborns.com.mx/imagenes-sanborns-ii/1200/9786073156615.jpg"),
            Movie("Escorpion","Terror","2000","https://www.sanborns.com.mx/imagenes-sanborns-ii/1200/9786073156615.jpg")

        )
    )

    override fun getMovies(): LiveData<List<Movie>> {
        return movieList
    }

    override fun saveNewMovie(movie: Movie){
        val data = movieList.value?.toMutableList()
        data?.add(movie)
        movieList.value = data
        this.getMovies()
    }

}