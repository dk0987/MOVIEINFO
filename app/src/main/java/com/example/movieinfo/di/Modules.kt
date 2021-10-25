package com.example.movieinfo.di

import com.example.movieinfo.data.remote.Movieapi
import com.example.movieinfo.data.repository.MovieRepositoryImpl
import com.example.movieinfo.domain.repository.MovieRepository
import com.example.movieinfo.domain.usecases.GetMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object Modules {

    @Provides
    @Singleton
    fun provideMovieApi() : Movieapi {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Movieapi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api : Movieapi) : MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository : MovieRepository) : GetMovie{
        return GetMovie(repository)
    }

}