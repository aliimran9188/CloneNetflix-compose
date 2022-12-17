package id.tomuchcoffee.netflixclone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.tomuchcoffee.netflixclone.R
import id.tomuchcoffee.netflixclone.ui.theme.NetflixCloneTheme



@ExperimentalMaterial3Api
@Composable
fun MovieAppBar(
    imageResourceID: Int = R.drawable.ic_netflix,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(modifier = modifier,
        title = {
            Image(
                painter = painterResource(id = imageResourceID),
                contentDescription = stringResource(R.string.netflix_app),
                modifier = Modifier.height(35.dp)
            )
        }
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MovieAppBArPreview(){
    NetflixCloneTheme {
        MovieAppBar()
    }
}