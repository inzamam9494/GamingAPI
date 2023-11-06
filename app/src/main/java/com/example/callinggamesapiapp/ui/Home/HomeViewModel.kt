package com.example.callinggamesapiapp.ui.Home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callinggamesapiapp.Repository.GetGamesByIdUseCase
import com.example.callinggamesapiapp.Repository.GetGamesUseCase
import com.example.callinggamesapiapp.model.domainItem.DetailedItemUI
import com.example.callinggamesapiapp.model.domainItem.GameItemUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// step 10


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase,
    //step 18
    private val getGamesByIdUseCase: GetGamesByIdUseCase
) : ViewModel() {
    private val _games = MutableLiveData<List<GameItemUI>>()
    val games: LiveData<List<GameItemUI>> get() = _games

    //step 18.1
    private val _gameById = MutableLiveData<DetailedItemUI>()
    val gameById: LiveData<DetailedItemUI> get() = _gameById

    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch {
            try {
                val games = getGamesUseCase()
                _games.value = games
                Log.d("gameViewModel1", "getGames $games")
            } catch (_: Exception) {
            }
        }
    }

    //step 18.2
    fun getGamesById(id:Int) {
        viewModelScope.launch {
            try {
                val game = getGamesByIdUseCase(id)
                _gameById.value = game
                Log.d("gameViewModel2", "getByIdGames $game")
            } catch (_:Exception){}
        }
    }

}