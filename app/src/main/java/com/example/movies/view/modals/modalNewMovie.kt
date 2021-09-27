package com.example.movies.view.modals

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.movies.MainActivity
import com.example.movies.R
import com.example.movies.interactor.implement.MovieRepoImplement
import com.example.movies.viewmodel.MainViewModel
import com.example.movies.viewmodel.MainViewModelFactory

class modalNewMovie: DialogFragment()  {

    private val viewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(MovieRepoImplement())).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.rounded_white_rectangle);


        return inflater.inflate(R.layout.modal_new_movie, container, false)
    }


    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.95).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<TextView>(R.id.btnConfirm).setOnClickListener {
            val title: String? = viewModel.edtTitle.value
            val genre: String? = viewModel.edtGenre.value
            val year: String? = viewModel.edtYear.value
            val poster: String? = viewModel.edtPoster.value
            if (title != null && year != null && genre != null && poster != null ) {
                viewModel.saveNewMovie(title, year, genre, poster)
                dialog?.dismiss()
            }else{
                Toast.makeText(context, "Please verify that all fields are filled out. ", Toast.LENGTH_SHORT).show()
            }
        }
        view.findViewById<TextView>(R.id.btnCancelar).setOnClickListener {
            dialog?.dismiss()
        }

        view.findViewById<TextView>(R.id.tv_title).addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.fieldTextChanged(s,R.id.tv_title)
            }
        })

        view.findViewById<TextView>(R.id.tv_genre).addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.fieldTextChanged(s,R.id.tv_genre)
            }
        })

        view.findViewById<TextView>(R.id.tv_year).addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.fieldTextChanged(s,R.id.tv_year)
            }
        })

        view.findViewById<TextView>(R.id.tv_poster).addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.fieldTextChanged(s,R.id.tv_poster)
            }
        })

    }
}