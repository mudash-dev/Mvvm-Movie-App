package com.example.mvvmtutorial.domain.repository

import com.example.mvvmtutorial.data.source.remote.Resource
import com.example.mvvmtutorial.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
}
