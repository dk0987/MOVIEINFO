package com.example.movieinfo.presentation.movieslist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.movieinfo.common.Constants
import com.example.movieinfo.domain.modal.Movies
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import java.util.*

@Composable
fun MovieItem(
    movie : Movies
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)) {
            Image(
                painter = rememberImagePainter( data = "${Constants.imageURL}${movie.poster_path}"),
                contentDescription = movie.original_title,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                alpha = 0.5f
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Black, Color.Transparent
                            ),
                            startY = 100f
                        )
                    ),
            )
            Box(
                modifier = Modifier
                    .height(450.dp)
                    .padding(top = 80.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = rememberImagePainter(data = "${Constants.imageURL}${movie.poster_path}"),
                    contentDescription = movie.original_title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, bottom = 5.dp),
                contentAlignment = Alignment.BottomStart,
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    item {
                        Text(
                            text = movie.original_title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(1.dp))
                        Text(
                            text = "Language : ${movie.original_language.uppercase(Locale.getDefault())} ",
                            fontWeight = FontWeight.Thin,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(1.dp))
                        Text(
                            text = "Release Date : ${movie.release_date}",
                            fontWeight = FontWeight.Thin,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        RatingBar(value = movie.vote_count%5,
                            ratingBarStyle = RatingBarStyle.HighLighted, onValueChange = {
                                
                            }) {

                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "Story Overview",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = movie.overview,
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            color = Color.White,
                            style = TextStyle(fontStyle = FontStyle.Italic)
                        )
                    }
                }
            }
        }
    }

}