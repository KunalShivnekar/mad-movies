package com.kshivnekar.moviesui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kshivnekar.arch.data.Response
import com.kshivnekar.moviesdata.remote.ApiFilm
import com.kshivnekar.moviesdata.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MoviesViewModel @Inject constructor(private val movieRepository: MovieRepository):ViewModel() {

    private val _moviesState = MutableLiveData<Response<List<ApiFilm>>>()

    val moviesState: LiveData<Response<List<ApiFilm>>>
        get() = _moviesState

    init {

    }


}
