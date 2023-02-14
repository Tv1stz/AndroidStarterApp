package com.example.androidstarterapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidstarterapp.ui.theme.AndroidStarterAppTheme
import com.example.androidstarterapp.R

@Composable
fun FilmScreen() {
    LazyColumn{
        items(20) {
            FilmCard(modifier = Modifier.padding(start = 2.dp, end = 2.dp, bottom = 5.dp))
        }
    }
}

@Composable
fun FilmCard(
    modifier: Modifier = Modifier,
    filmViewModel: FilmViewModel = viewModel()
) {
    val filmUiState by filmViewModel.uiState.collectAsState()
    Card(
        modifier = modifier,
        elevation = 10.dp
    ) {
        Row {
            Image(
                painter = painterResource(id = filmUiState.photo),
                contentDescription = "film image",
                modifier = Modifier
                    .padding(5.dp)
                    .width(100.dp)
            )
            FilmInfo(modifier = Modifier
                .padding(start = 5.dp),
                nameFilm = filmUiState.name,
                yearFilm = filmUiState.date_publication,
                ratingFilm = filmUiState.rating
                )
        }
    }
}

@Composable
fun FilmInfo(
    modifier: Modifier = Modifier,
    nameFilm: Int,
    yearFilm: Int,
    ratingFilm: Int
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = nameFilm),
            style = MaterialTheme.typography.h6,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
        ){
            Text(
                text = stringResource(id = R.string.film_name_eng),
            )
            Text(
                text = stringResource(id = yearFilm),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        Text(
            text = stringResource(id = ratingFilm),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidStarterAppTheme {
        FilmScreen()
    }
}