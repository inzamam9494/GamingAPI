package com.example.callinggamesapiapp.ui.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callinggamesapiapp.Repository.GetGamesUseCase
import com.example.callinggamesapiapp.model.domainItem.GameItemUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// step 10

@HiltViewModel
class HomeViewModel @Inject constructor(private val getGamesUseCase: GetGamesUseCase) : ViewModel() {
    private val _games = MutableStateFlow(emptyList<GameItemUI>())
    val games: StateFlow<List<GameItemUI>> get() = _games

    init {
        getGames()
    }

private fun getGames(){
        viewModelScope.launch {
            try {
                val games = getGamesUseCase()
                _games.value = games
                Log.d("gameViewModel", "getGames $games")
            }
            catch (_:Exception){}
        }
    }

}