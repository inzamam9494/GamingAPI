package com.example.callinggamesapiapp.ui

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.callinggamesapiapp.ConstantApi.Companion.KEY_GAME_ID
import com.example.callinggamesapiapp.ConstantApi.Screens.DETAIL_SCREEN
import com.example.callinggamesapiapp.ConstantApi.Screens.HOME_SCREEN
import com.example.callinggamesapiapp.ui.Home.DetailScreen
import com.example.callinggamesapiapp.ui.Home.HomeViewModel

// step 19
sealed class Screens(val route: String){
    object Home: Screens(route = HOME_SCREEN)
    object Details: Screens(route = DETAIL_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, gameViewModel: HomeViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeScreen(gameViewModel = gameViewModel, navController = navController)
        }

        composable(route = Screens.Detail.route + "/{$KEY_GAME_ID}") { backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(KEY_GAME_ID)?: "1", gameViewModel = gameViewModel, navController = navController)
        }

    }

}