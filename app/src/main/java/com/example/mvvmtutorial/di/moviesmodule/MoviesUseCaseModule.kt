package com.example.mvvmtutorial.di.moviesmodule

import com.example.mvvmtutorial.domain.repository.MovieRepository
import com.example.mvvmtutorial.domain.usecase.GetPopularMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesUseCaseModule {

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(repository: MovieRepository): GetPopularMovies =
        GetPopularMovies(repository)
}