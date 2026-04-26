package com.kshivnekar.moviesui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kshivnekar.arch.data.Response
import com.kshivnekar.moviesdata.remote.ApiFilm
import com.kshivnekar.moviesdata.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieRepository: MovieRepository):ViewModel() {

    private val _moviesState = MutableStateFlow<Response<List<ApiFilm>>>(Response.Loading)

    val moviesState: StateFlow<Response<List<ApiFilm>>> = _moviesState.asStateFlow()

    init {
        viewModelScope.launch {
            _moviesState.value = movieRepository.fetchTopRated()
        }
    }
}
