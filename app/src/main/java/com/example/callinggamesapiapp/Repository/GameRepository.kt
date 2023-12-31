package com.example.callinggamesapiapp.Repository

import com.example.callinggamesapiapp.model.domainItem.DetailedItemUI
import com.example.callinggamesapiapp.model.domainItem.GameItemUI
import com.example.callinggamesapiapp.model.domainItem.toDetailedItemUI
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

    //step 16
   suspend fun getGamesById(id: Int): DetailedItemUI {
       return gameService.getGameById(id).toDetailedItemUI()
   }
}


