package com.example.callinggamesapiapp.ui.Home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.callinggamesapiapp.ConstantApi.Companion.KEY_GAME_ID
import com.example.callinggamesapiapp.ConstantApi.Screens.DETAIL_SCREEN
import com.example.callinggamesapiapp.ConstantApi.Screens.HOME_SCREEN

sealed class Screens(val route: String) {

    object Home : Screens(route = HOME_SCREEN)
    object Detail : Screens(route = DETAIL_SCREEN)

}

@Composable
fun SetupNavHost(navController: NavHostController, gameViewModel: HomeViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeScreen(
                gameViewModel = gameViewModel, navController = navController,
                modifier = Modifier
            )
        }

        composable(route = Screens.Detail.route + "/{$KEY_GAME_ID}") {
            DetailedScreen(
                id = it.arguments?.getString(KEY_GAME_ID) ?: "1",
                gameViewModel = gameViewModel,
                navController = navController,
                modifier = Modifier
            )
        }

    }

}

