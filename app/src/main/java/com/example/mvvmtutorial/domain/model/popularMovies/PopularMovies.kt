package com.example.mvvmtutorial.domain.model.popularMovies

import com.example.mvvmtutorial.domain.model.movie.Movie

data class PopularMovies(
    val page: Int,
    val results: List<Movie>
)
