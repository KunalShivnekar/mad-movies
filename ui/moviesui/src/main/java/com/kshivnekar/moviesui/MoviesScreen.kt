package com.kshivnekar.moviesui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kshivnekar.arch.data.Response
import com.kshivnekar.moviesdata.remote.ApiFilm

@Composable
fun MoviesScreen(
    movies: Response<List<ApiFilm>>,
    onMovieSelected:(movie: ApiFilm)->Unit,
    modifier: Modifier = Modifier
) {
    when(movies){
        is Response.Error -> {}
        Response.Loading -> {}
        is Response.Success -> {
            Column(
                modifier = modifier
                    .padding(8.dp)
            ) {
                Text(text = "Top Movies")
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(movies.data) { movie ->
                        MoviesItem(
                            movie = movie,
                            onClick = onMovieSelected
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 720)
@Composable
fun MoviesScreenPreview(){
    MoviesScreen(
        movies = Response.Success(listOf(
            ApiFilm(
                id = 1,
                title = "Title",
                overview = "overview",
                posterPath = "asjkdadhjks",
                backdropPath = "askjdhkasd",
                voteAverage = "8.0"
            ),
            ApiFilm(
                id = 1,
                title = "Title",
                overview = "overview",
                posterPath = "asjkdadhjks",
                backdropPath = "askjdhkasd",
                voteAverage = "8.0"
            ),
            ApiFilm(
                id = 1,
                title = "Title",
                overview = "overview",
                posterPath = "asjkdadhjks",
                backdropPath = "askjdhkasd",
                voteAverage = "8.0"
            )
        )),
        onMovieSelected = {}
    )
}