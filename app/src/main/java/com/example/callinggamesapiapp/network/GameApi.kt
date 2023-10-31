package com.example.callinggamesapiapp.network

import com.example.callinggamesapiapp.ConstantApi.Companion.GAME_ENDPOINT
import com.example.callinggamesapiapp.model.GamesItem
import retrofit2.Response
import retrofit2.http.GET

// step 4

interface GameApi {
    @GET(GAME_ENDPOINT)
    suspend fun getGames(): Response<List<GamesItem>>
}