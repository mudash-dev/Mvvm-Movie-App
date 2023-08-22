package com.example.mvvmtutorial.data.repository

import retrofit2.HttpException
import com.example.mvvmtutorial.data.source.local.roomdb.dao.MovieDao
import com.example.mvvmtutorial.data.source.local.roomdb.dao.PopularMoviesDao
import com.example.mvvmtutorial.data.source.remote.MovieApiService
import com.example.mvvmtutorial.data.source.remote.Resource
import com.example.mvvmtutorial.domain.model.movie.Movie
import com.example.mvvmtutorial.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class MovieRepositoryImpl constructor(
    private val movieApiService: MovieApiService,
    private val popularMoviesDao: PopularMoviesDao,
    private val movieDao: MovieDao
) : MovieRepository {

    override fun getPopularMovies(): Flow<Resource<List<Movie>>> = flow{

        emit(Resource.Loading())
        try {
            fetchAndInsertPopularMovies(movieApiService, popularMoviesDao, movieDao)
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops!Something went wrong"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Unable to reach server,check your internet connection"
                )
            )
        }
        emit(Resource.Success(getPopularMoviesFromDb(movieDao)))
    }

    private suspend fun fetchAndInsertPopularMovies(
        movieApiService: MovieApiService,
        popularMoviesDao: PopularMoviesDao,
        movieDao: MovieDao
    ) {
        val remotePopularMovies = movieApiService.getPopularMovies()
        popularMoviesDao.insertPopularMovies(remotePopularMovies.toPopularMoviesEntity())
        movieDao.insertMovieList(remotePopularMovies.results.map { it.toMovieEntity() })
    }

    private suspend fun getPopularMoviesFromDb(movieDao: MovieDao): List<Movie>  {
        val newPopularMovies = movieDao.getMovieList().map { it.toMovie() }
        return newPopularMovies
    }
}