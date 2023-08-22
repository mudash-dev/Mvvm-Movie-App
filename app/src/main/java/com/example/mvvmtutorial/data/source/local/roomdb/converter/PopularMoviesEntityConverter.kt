package com.example.mvvmtutorial.data.source.local.roomdb.converter

import androidx.room.TypeConverter
import com.example.mvvmtutorial.data.source.local.roomdb.entity.MovieEntity
import com.example.mvvmtutorial.domain.model.movie.Movie
// import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class PopularMoviesEntityConverter {

    @TypeConverter
    fun fromStringToMovieList(value: String): List<Movie>? =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<Movie>>(Types.newParameterizedType(List::class.java, Movie::class.java))
            .fromJson(value)

    @TypeConverter
    fun fromMovieListTypeToString(movieListType: List<Movie>?): String =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<Movie>>(Types.newParameterizedType(List::class.java, Movie::class.java))
            .toJson(movieListType)

    @TypeConverter
    fun fromStringToMovieEntityList(value: String): List<MovieEntity>? =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<MovieEntity>>(Types.newParameterizedType(List::class.java, MovieEntity::class.java))
            .fromJson(value)

    @TypeConverter
    fun fromMovieEntityListTYpeToString(movieEntityListType: List<MovieEntity>?): String =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<MovieEntity>>(Types.newParameterizedType(List::class.java, MovieEntity::class.java))
            .toJson(movieEntityListType)
}