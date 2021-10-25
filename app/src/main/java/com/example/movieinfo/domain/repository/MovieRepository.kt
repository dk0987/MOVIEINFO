package com.example.movieinfo.domain.repository

import com.example.movieinfo.data.remote.dto.Dto

interface MovieRepository {
    suspend fun getMovies() : Dto
}