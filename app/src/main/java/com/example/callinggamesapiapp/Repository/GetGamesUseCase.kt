package com.example.callinggamesapiapp.Repository

import com.example.callinggamesapiapp.model.domainItem.DetailedItemUI
import com.example.callinggamesapiapp.model.domainItem.GameItemUI
import javax.inject.Inject

// step 9

class GetGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItemUI> {
        return gameRepository.getGames().shuffled()
    }
}
