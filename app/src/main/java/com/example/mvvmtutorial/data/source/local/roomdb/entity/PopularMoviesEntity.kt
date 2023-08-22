package com.example.mvvmtutorial.data.source.local.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmtutorial.domain.model.popularMovies.PopularMovies

@Entity(tableName = PopularMoviesEntity.TABLE_NAME)
class PopularMoviesEntity(
    @PrimaryKey(autoGenerate = true)
    val primaryKeyId: Int? = null,
    val page: Int,
    val results: List<MovieEntity>
) {
    fun toPopularMovies(): PopularMovies {
        return PopularMovies(
            page = page,
            results = results.map { it.toMovie() }
        )
    }

    companion object {
        const val TABLE_NAME = "popular_movies"
    }
}