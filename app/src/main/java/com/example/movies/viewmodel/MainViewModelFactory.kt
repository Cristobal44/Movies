package com.example.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.interactor.MoviesRepo

class MainViewModelFactory (private val moviesRepo: MoviesRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MoviesRepo::class.java).newInstance(moviesRepo)
    }
}