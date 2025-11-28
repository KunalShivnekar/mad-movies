package com.kshivnekar.moviesui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.kshivnekar.movies.R
import com.kshivnekar.moviesdata.remote.ApiFilm


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MoviesItem(
    movie:ApiFilm,
    onClick:(movie: ApiFilm)->Unit,
    modifier:Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable(onClick = { onClick(movie) }),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Column() {
                GlideImage(
                    model = movie.posterPath,
                    loading = placeholder(R.drawable.ic_star),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(text = movie.voteAverage?:"0")
                }
            }

            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = movie.title,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = movie.overview
                )
            }

        }
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MoviesItemPreview() {
    MoviesItem(
        ApiFilm(
            id = 1,
            title = "Title",
            overview = "overview",
            posterPath = "asjkdadhjks",
            backdropPath = "askjdhkasd",
            voteAverage = "8.0"
        ),
        onClick = {}
    )
}