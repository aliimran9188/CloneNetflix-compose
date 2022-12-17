package id.tomuchcoffee.netflixclone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    modifier: Modifier = Modifier,
    isTransparan: Boolean? = false,
    onBack: (()-> Unit)? = null,
    onViewChange: ((isGrid: Boolean)-> Unit)? = null
) {
    var isGrid by remember {
        mutableStateOf(false)
    }
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = if (isTransparan == true) Color.Transparent else MaterialTheme.colorScheme.surface
        ),
        title = {
            Image(
                painter = painterResource(id = imageResourceID),
                contentDescription = stringResource(R.string.netflix_app),
                modifier = Modifier.height(35.dp)
            )
        },
        navigationIcon = {
            if (onBack != null) IconButton(onClick = { onBack()}) {
                Icon(imageVector = Icons.Rounded.ArrowBack,
                    tint = if (isTransparan==true) Color.White else Color.Black,
                    contentDescription = "")

            }
        },
        actions = {
            if (onViewChange != null) IconButton(onClick = {
                isGrid = !isGrid
                onViewChange(isGrid)

            }) {
                Icon(
                    imageVector = if (isGrid) Icons.Rounded.GridView else Icons.Rounded.ViewList,
                    contentDescription = "",
                    tint = if (isTransparan==true) Color.White else Color.Black,
                )

            }
        }
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MovieAppBArPreview() {
    NetflixCloneTheme {
        MovieAppBar(
            isTransparan = true,
            onBack = {},
            onViewChange = {}
        )
    }
}