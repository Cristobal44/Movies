package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.interactor.implement.MovieRepoImplement
import com.example.movies.view.adapter.MovieListAdapter
import com.example.movies.view.modals.modalNewMovie
import com.example.movies.viewmodel.MainViewModel
import com.example.movies.viewmodel.MainViewModelFactory
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this,MainViewModelFactory(MovieRepoImplement())).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMovies().observe(this, Observer {movies ->
            println(movies)

            val recyclerview = findViewById<RecyclerView>(R.id.rv_movies)
            val adapter = MovieListAdapter (movies,this)
            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter = adapter
        })



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.add_new_movie->{
                ShowModalFragment()
                //showNewMovieDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun ShowModalFragment() {
        val modalFragment = modalNewMovie()
        modalFragment.show(supportFragmentManager, "MY_BOTTOM_SHEET")
    }


}