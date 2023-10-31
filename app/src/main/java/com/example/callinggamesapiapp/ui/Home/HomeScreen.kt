package com.example.callinggamesapiapp.ui.Home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.callinggamesapiapp.R
import com.example.callinggamesapiapp.model.domainItem.GameItemUI

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val games by homeViewModel.games.collectAsState()

    LazyColumn{
        items(games){item: GameItemUI ->
            GameCard(game = item, onClick = {}, modifier = Modifier)
        }
    }

}


//@Composable
//fun GameCard(game: GameItemUI) {
//
//    val image = rememberImagePainter(data = game.thumbnail)
//
//    Card(
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
//        shape = RoundedCornerShape(5.dp),
//        modifier = Modifier
//            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
//            .fillMaxSize()
//
//    ) {
//
//        Column {
//
//            Image(
//                painter = image,
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxWidth().height(250.dp)
//            )
//
//            Column(modifier = Modifier.padding(10.dp)) {
//
//                game.title?.let { Text(text = it, fontWeight = FontWeight.Bold) }
//                game.shortDescription?.let { Text(text = it, maxLines = 2, overflow = TextOverflow.Ellipsis) }
//
//            }
//
//        }
//
//    }
//
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCard(
    game: GameItemUI,
    onClick: (GameItemUI) -> Unit,
    modifier: Modifier
) {

    // other option rememberImagePainter(data = )
//    val image = rememberAsyncImagePainter(data =game.thumbnail )


    Card(
        modifier = Modifier,
        onClick = { onClick(game) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current),
            contentDescription = game.thumbnail,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .border(1.dp, MaterialTheme.colorScheme.onSurface, MaterialTheme.shapes.medium)
        )

        Column {
            Text(text = game.title!!,
                fontWeight = FontWeight.Bold)
            Text(text = game.shortDescription!!, maxLines = 2, overflow = TextOverflow.Ellipsis)
        }

    }
}