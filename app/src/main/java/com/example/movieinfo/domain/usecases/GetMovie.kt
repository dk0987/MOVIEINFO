package com.example.movieinfo.domain.usecases

import com.example.movieinfo.common.Resource
import com.example.movieinfo.data.remote.dto.Dto
import com.example.movieinfo.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetMovie(
    private val repository: MovieRepository
) {
      operator  fun invoke() : Flow<Resource<Dto>> = flow {
          try {
              emit(Resource.Loading<Dto>())
              val dto = repository.getMovies()
              emit(Resource.Success<Dto>(dto))
          }catch (e : HttpException){
              emit(Resource.Error<Dto>(e.localizedMessage ?: "Check Your Internet Connection " ))
          }
          catch (e : IOException){
              emit(Resource.Error<Dto>("Check Your Internet Connection"))
          }
      }
}