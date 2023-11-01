package com.example.callinggamesapiapp

// step 2

class ConstantApi {
    companion object{
        const val BASE_URL = "https://www.freetogame.com/api/"
        const val GAME_ENDPOINT = "games"
        const val GAME_ID_ENDPOINT = "game?id"
        const val KEY_GAME_ID = "com.example.callinggamesapiapp.id"
    }

    // step 12 for navigation screen
    object Screens{
        const val HOME_SCREEN = "home_screen"
        const val DETAIL_SCREEN = "detail_screen"
    }

}