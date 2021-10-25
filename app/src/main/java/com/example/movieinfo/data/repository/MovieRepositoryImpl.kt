package com.example.movieinfo.data.repository

import com.example.movieinfo.data.remote.Movieapi
import com.example.movieinfo.data.remote.dto.Dto
import com.example.movieinfo.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api : Movieapi
) : MovieRepository {
    override suspend fun getMovies(): Dto {
        return api.getMovies()
    }
}