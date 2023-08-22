package com.example.mvvmtutorial.di.moviesmodule

import android.app.Application
import com.example.mvvmtutorial.data.source.local.roomdb.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesDataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = MovieDataBase.getDataBase(application)

    @Singleton
    @Provides
    fun providePopularMoviesDao(dataBase: MovieDataBase) =
        dataBase.getPopularMoviesDao()

    @Singleton
    @Provides
    fun provideMoviesDao(dataBase: MovieDataBase) =
        dataBase.getMovieDao()
}