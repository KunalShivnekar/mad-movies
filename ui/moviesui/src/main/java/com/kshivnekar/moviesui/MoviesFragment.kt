package com.kshivnekar.moviesui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kshivnekar.arch.data.Response
import com.kshivnekar.arch.data.succeeded
import com.kshivnekar.movies.R
import com.kshivnekar.movies.databinding.FragmentMoviesBinding
import com.kshivnekar.moviesdata.remote.ApiFilm
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesFragment : Fragment() {

    @Inject
    internal lateinit var adapter: MoviesAdapter

    private lateinit var binding: FragmentMoviesBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val moviesViewModel by viewModels<MoviesViewModel>(){viewModelFactory}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesViewModel.moviesState.observe(this, ::updateState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recycler.layoutManager = linearLayoutManager
        binding.recycler.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), linearLayoutManager.orientation).apply {
            setDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.divider)!!)
        }
        binding.recycler.addItemDecoration(dividerItemDecoration)
        //adapter.setOnClick { id -> FilmDetailActivity.start(this, id) }
    }

    private fun updateState(response:Response<List<ApiFilm>>) {
        when (response) {
            is Response.Success -> displayResults(response.data)
            else -> displayError()
        }
    }

    private fun displayResults(results: List<ApiFilm>) {
        adapter.submitList(results)
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