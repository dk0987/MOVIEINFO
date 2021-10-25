package com.example.movieinfo.presentation.movieslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieinfo.presentation.movieslist.component.MovieItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@ExperimentalPagerApi
@Composable
fun MovieList(
   viewModel: MovieListViewModel = hiltViewModel()
) {
    viewModel.state.value.movie.let {movie ->
        HorizontalPager(movie.size) { page->
            MovieItem(movie = movie[page])
       }
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )){
                        append("M")
                    }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal
                    )){
                        append("ovie")
                    }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )){
                        append("I")
                    }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Normal
                    )){
                        append("nfo")
                    }
            },
            letterSpacing = 5.sp
        )
    }
    if (viewModel.state.value.loading){
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(color = Color.Green)
        }
    }
    else if (viewModel.state.value.error.isNotEmpty()){
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = viewModel.state.value.error,
                color = Color.Red,
                fontSize = 18.sp
            )
        }
    }
}