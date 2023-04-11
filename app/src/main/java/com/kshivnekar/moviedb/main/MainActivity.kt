package com.kshivnekar.moviedb.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kshivnekar.moviedb.R
import com.kshivnekar.moviesui.MoviesFragment
import dagger.hilt.android.AndroidEntryPoint

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