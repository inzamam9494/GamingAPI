package com.example.callinggamesapiapp.network

import com.example.callinggamesapiapp.ConstantApi.Companion.GAME_ENDPOINT
import com.example.callinggamesapiapp.ConstantApi.Companion.GAME_ID_ENDPOINT
import com.example.callinggamesapiapp.model.DetailedItem
import com.example.callinggamesapiapp.model.GamesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// step 4

interface GameApi {
    @GET(GAME_ENDPOINT)
    suspend fun getGames(): Response<List<GamesItem>>

    @GET(GAME_ID_ENDPOINT)
    suspend fun getGamesById(@Query(value = "id") id: Int): Response<List<DetailedItem>>
}