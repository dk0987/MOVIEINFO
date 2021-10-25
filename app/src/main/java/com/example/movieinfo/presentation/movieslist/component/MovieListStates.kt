package com.example.movieinfo.presentation.movieslist.component

import com.example.movieinfo.domain.modal.Movies

data class MovieListStates(
    val movie : List<Movies> = emptyList(),
    val loading : Boolean = false ,
    val error : String = ""
)
