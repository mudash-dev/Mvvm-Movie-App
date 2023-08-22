package com.example.mvvmtutorial.domain.usecase

import com.example.mvvmtutorial.data.source.remote.Resource
import com.example.mvvmtutorial.domain.model.movie.Movie
import com.example.mvvmtutorial.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

// For a bigger project implement the Use Case in the Data layer instead of Domain Layer
class GetPopularMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> {
        return movieRepository.getPopularMovies()
    }
}
