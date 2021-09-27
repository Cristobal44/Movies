package com.example.movies.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.model.Movie

class MovieListAdapter(
    private val movies: List<Movie>,
    private val context: Context ) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_recycler_movie, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(movies[position].poster).into(holder.txt_mv_poster)
        holder.txt_mv_title.text = movies[position].title
        holder.txt_mv_year.text = movies[position].year
        holder.txt_mv_genre.text = movies[position].genre
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView){
        var txt_mv_poster: ImageView
        var txt_mv_title: TextView
        var txt_mv_year: TextView
        var txt_mv_genre: TextView

        init {
            txt_mv_poster = itemView.findViewById(R.id.mv_poster)
            txt_mv_title = itemView.findViewById(R.id.mv_title)
            txt_mv_year = itemView.findViewById(R.id.mv_year)
            txt_mv_genre = itemView.findViewById(R.id.mv_genre)
        }

    }
}