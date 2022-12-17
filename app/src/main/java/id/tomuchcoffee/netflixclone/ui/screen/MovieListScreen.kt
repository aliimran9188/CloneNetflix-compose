package id.tomuchcoffee.netflixclone.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.tomuchcoffee.netflixclone.data.MovieDatasource
import id.tomuchcoffee.netflixclone.domain.model.Movie
import id.tomuchcoffee.netflixclone.ui.component.MovieAppBar
import id.tomuchcoffee.netflixclone.ui.component.MovieItem


@ExperimentalMaterial3Api
@Composable
fun MovieListScreen(){

    val movies : List<Movie> by rememberSaveable {
        mutableStateOf(MovieDatasource.getNowPlayingMovie())
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
        MovieAppBar()
        })
    {  contentPadding ->
        LazyColumn(modifier = Modifier.padding(contentPadding), verticalArrangement = Arrangement.spacedBy(16.dp)){
            items(movies){ movie ->
                MovieItem(isGrid = false, movie = movie, modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}
