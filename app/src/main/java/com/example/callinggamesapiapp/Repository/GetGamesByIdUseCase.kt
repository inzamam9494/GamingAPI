package com.example.callinggamesapiapp.Repository

import com.example.callinggamesapiapp.model.domainItem.DetailedItemUI
import javax.inject.Inject


// step 17

class GetGamesByIdUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(id: Int): List<DetailedItemUI> {
        return gameRepository.getGamesById(id).shuffled()
    }
}