package com.example.callinggamesapiapp.ui.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.callinggamesapiapp.model.domainItem.GameItemUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    gameViewModel: HomeViewModel,
    onClickDetail: () -> Unit,
    modifier: Modifier
) {

    val games = gameViewModel.games.observeAsState(listOf()).value

    Scaffold(topBar = {
        Surface {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Game API",
                    style = MaterialTheme.typography.titleLarge
                )
            })
        }

    }) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn {
                items(games) { game ->
                    GameCard(
                        gameItem = game,
                        onClick = onClickDetail,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCard(
    gameItem: GameItemUI,
    onClick: () -> Unit,
    modifier: Modifier
) {

    Card(
        onClick = onClick,
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(model = gameItem.thumbnail),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .width(175.dp)
                    .height(115.dp)
            )
            Column(modifier = Modifier.weight(0.1f)) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = gameItem.title!!,
                        style = MaterialTheme.typography.titleMedium
                    )
                    gameItem.shortDescription?.let {
                        Text(
                            text = it,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewScreens() {
    MaterialTheme {

    }
}