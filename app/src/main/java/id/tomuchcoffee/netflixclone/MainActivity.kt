package id.tomuchcoffee.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import id.tomuchcoffee.netflixclone.data.MovieDatasource
import id.tomuchcoffee.netflixclone.domain.model.Movie
import id.tomuchcoffee.netflixclone.ui.component.MovieAppBar
import id.tomuchcoffee.netflixclone.ui.screen.MovieGridScreen
import id.tomuchcoffee.netflixclone.ui.screen.MovieListScreen
import id.tomuchcoffee.netflixclone.ui.theme.NetflixCloneTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixCloneTheme {
                NetflixCloneApps()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun NetflixCloneApps(){

    val movies : List<Movie> by rememberSaveable {
        mutableStateOf(MovieDatasource.getNowPlayingMovie())
    }
    var isGrid by remember {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MovieAppBar(
                onViewChange = {isGrid = it}
            )
        })
    {  contentPadding ->
        if (isGrid) MovieGridScreen(contentPadding, movies)
        else MovieListScreen(contentPadding, movies)
    }


}
