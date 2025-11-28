package com.kshivnekar.moviedb.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kshivnekar.moviedb.R
import com.kshivnekar.moviesui.MoviesFragment
import com.kshivnekar.moviesui.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.root, MoviesFragment.newInstance())
            .commit()
    }
}