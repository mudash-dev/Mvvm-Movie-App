package com.example.mvvmtutorial.data.source.remote.dto

import com.example.mvvmtutorial.data.source.local.roomdb.entity.PopularMoviesEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularMoviesDto(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<MovieDto>,
    @Json(name = "total_pages")
    val total_pages: Int,
    @Json(name = "total_results")
    val total_results: Int,

) {
    fun toPopularMoviesEntity(): PopularMoviesEntity {
        return PopularMoviesEntity(
            page = page,
            results = results.map { it.toMovieEntity() },
        )
    }
}
