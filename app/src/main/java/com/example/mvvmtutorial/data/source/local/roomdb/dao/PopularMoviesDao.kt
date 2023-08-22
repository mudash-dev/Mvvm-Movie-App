package com.example.mvvmtutorial.data.source.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmtutorial.data.source.local.roomdb.entity.PopularMoviesEntity

@Dao
interface PopularMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovieList(popularMovies: List<PopularMoviesEntity>)

    @Query("SELECT * FROM ${PopularMoviesEntity.TABLE_NAME}")
    suspend fun getPopularMovieList(): List<PopularMoviesEntity>
    @Query("DELETE FROM ${PopularMoviesEntity.TABLE_NAME}")
    suspend fun deleteAll()
}
