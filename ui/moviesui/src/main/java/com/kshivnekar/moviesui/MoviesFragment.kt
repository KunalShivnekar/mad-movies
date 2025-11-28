package com.kshivnekar.moviesui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kshivnekar.arch.data.Response
import com.kshivnekar.arch.data.succeeded
import com.kshivnekar.movies.R
import com.kshivnekar.movies.databinding.FragmentMoviesBinding
import com.kshivnekar.moviesdata.remote.ApiFilm
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MoviesFragment : Fragment() {
    private val moviesViewModel:MoviesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val movies = moviesViewModel.moviesState.observeAsState(Response.Loading).value
                MoviesScreen(
                    movies = movies,
                    onMovieSelected = {},
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    private fun displayError() {
        Toast.makeText(requireContext(), R.string.connection_error, Toast.LENGTH_SHORT).show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = MoviesFragment()
    }
}