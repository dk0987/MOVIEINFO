package com.example.movieinfo.data.remote.dto

import com.example.movieinfo.domain.modal.Movies

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)

fun Result.toMovie(): Movies {
    return Movies(
        poster_path = poster_path ,
        original_title = original_title,
        original_language = original_language ,
        release_date = release_date ,
        overview = overview ,
        vote_count = vote_count.toFloat()
    )
}