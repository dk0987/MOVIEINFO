package com.example.movieinfo.presentation.movieslist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.common.Resource
import com.example.movieinfo.data.remote.dto.toMovie
import com.example.movieinfo.domain.usecases.GetMovie
import com.example.movieinfo.presentation.movieslist.component.MovieListStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovie: GetMovie
) : ViewModel() {
    private val _state = mutableStateOf(MovieListStates())
    val state : State<MovieListStates> = _state

    init {
        getMovies()
    }

    private fun getMovies() {
        getMovie.invoke().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = result.data?.results?.let { movies->
                        state.value.copy(
                            movie = movies.map { it.toMovie() },
                            loading = false
                        )
                    }!!
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        error = result.message.toString(),
                        loading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = state.value.copy(
                        loading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}