package com.example.androidstarterapp.ui

import com.example.androidstarterapp.R

data class FilmUiState(
    val id: Int = 1,
    val name: Int = R.string.film_name,
    val photo: Int = R.drawable.stars,
    val date_publication: Int = R.string.release_year,
    val rating: Int = R.string.film_rating,
)

