package com.example.movieinfo.data.remote

import com.example.movieinfo.data.remote.dto.Dto
import retrofit2.http.GET

interface Movieapi {

    @GET("3/movie/popular?api_key=631609a6656fa51347769b79262503b0")
    suspend fun getMovies() : Dto
}