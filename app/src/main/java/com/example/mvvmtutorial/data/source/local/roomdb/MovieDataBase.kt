package com.example.mvvmtutorial.data.source.local.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmtutorial.data.source.local.roomdb.converter.PopularMoviesEntityConverter
import com.example.mvvmtutorial.data.source.local.roomdb.dao.MovieDao
import com.example.mvvmtutorial.data.source.local.roomdb.dao.PopularMoviesDao
import com.example.mvvmtutorial.data.source.local.roomdb.entity.MovieEntity
import com.example.mvvmtutorial.data.source.local.roomdb.entity.PopularMoviesEntity

@Database(
    entities = [PopularMoviesEntity::class, MovieEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(PopularMoviesEntityConverter::class)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

    abstract fun getPopularMoviesDao(): PopularMoviesDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDataBase? = null

        fun getDataBase(context: Context): MovieDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDataBase::class.java,
                    "movie_database",
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
