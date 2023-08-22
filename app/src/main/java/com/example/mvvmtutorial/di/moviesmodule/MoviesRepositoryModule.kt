package com.example.mvvmtutorial.di.moviesmodule

import com.example.mvvmtutorial.data.repository.MovieRepositoryImpl
import com.example.mvvmtutorial.data.source.local.roomdb.dao.MovieDao
import com.example.mvvmtutorial.data.source.local.roomdb.dao.PopularMoviesDao
import com.example.mvvmtutorial.data.source.remote.MovieApiService
import com.example.mvvmtutorial.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesRepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepositoryImpl(
        movieApiService: MovieApiService,
        popularMoviesDao: PopularMoviesDao,
        movieDao: MovieDao,
    ) : MovieRepository = MovieRepositoryImpl(movieApiService,popularMoviesDao,movieDao)
}