package com.example.callinggamesapiapp.Repository

import com.example.callinggamesapiapp.model.domainItem.GameItemUI
import com.example.callinggamesapiapp.model.domainItem.toGameItemUI
import com.example.callinggamesapiapp.network.GameService
import javax.inject.Inject

// step 8

class GameRepository @Inject constructor(private val gameService: GameService) {
    suspend fun getGames(): List<GameItemUI>{
        return gameService.getGames().map {
            it.toGameItemUI()
        }
    }
}