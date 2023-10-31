package com.example.callinggamesapiapp.network

import com.example.callinggamesapiapp.model.GamesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// step 6

class GameService @Inject constructor(private val gameApi: GameApi) {
    suspend fun getGames(): List<GamesItem> {
        return withContext(Dispatchers.IO) {
            val games = gameApi.getGames()
            games.body() ?: emptyList()
        }
    }
}