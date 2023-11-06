package com.example.callinggamesapiapp.ui.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.callinggamesapiapp.model.domainItem.GameItemUI


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    gameViewModel: HomeViewModel,
    navController: NavController,
    modifier: Modifier
) {

    val games = gameViewModel.games.observeAsState(listOf()).value

    Scaffold(topBar = {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White
                        ),
                        startY = 0f,
                        endY = 32f // Adjust this value to control the fading height
                    )
                )
        ) {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Game API",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            })
        }

    }) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn {
                items(games) { game ->
                    GameCard(
                        gameItem = game,
                        navController = navController,
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
    navController: NavController,
    modifier: Modifier
) {

    Card(
        onClick = { navController.navigate(Screens.Detail.route + "/${gameItem.id}") },
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
                    .shadow(2.dp, RoundedCornerShape(20.dp))
            )
            Column(modifier = Modifier.weight(0.1f)) {
                Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = gameItem?.title?: "",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = gameItem?.shortDescription?:"",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )


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