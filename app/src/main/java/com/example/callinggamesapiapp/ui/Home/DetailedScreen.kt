package com.example.callinggamesapiapp.ui.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.callinggamesapiapp.model.domainItem.DetailedItemUI


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedScreen(
    onBackClick: () -> Unit,
    gameViewModel: HomeViewModel,
    modifier: Modifier,
    id: String
) {
    // Fetch the detailed information only if it hasn't been fetched yet.

    gameViewModel.getGamesById(id.toInt())
    val gameDetail = gameViewModel.gameById.observeAsState().value

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Game Detail",
                style = MaterialTheme.typography.titleMedium
            )

        },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            LazyColumn {
                item { gameDetail?.let { it1 -> GameScreen(detailItem = it1, modifier = Modifier) } }

            }

        }
    }
}


@Composable
fun GameScreen(
    detailItem: DetailedItemUI,
    modifier: Modifier
) {
    Column() {
        detailItem.title?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
        }
        Image(
            painter = rememberAsyncImagePainter(model = detailItem.thumbnail),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        detailItem.description?.let { Text(text = it) }


    }
}

// detailItem!![0]?.title ?: "",