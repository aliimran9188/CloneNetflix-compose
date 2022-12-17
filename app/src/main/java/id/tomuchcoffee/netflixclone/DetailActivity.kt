package id.tomuchcoffee.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import id.tomuchcoffee.netflixclone.domain.model.Movie
import id.tomuchcoffee.netflixclone.ui.screen.MovieDetailScreen
import id.tomuchcoffee.netflixclone.ui.theme.NetflixCloneTheme

@ExperimentalMaterial3Api
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixCloneTheme {
                intent.extras?.getParcelable<Movie>(EXTRA_MOVIE)?.let { movie ->
                    setContent{
                        MovieDetailScreen(movie = movie) {
                            finish()
                        }
                    }
                }

            }
        }
    }

    companion object{
        const val EXTRA_MOVIE ="extra_movie"
    }
}