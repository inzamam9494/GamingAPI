package com.example.callinggamesapiapp.ui.Home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.callinggamesapiapp.ConstantApi.Companion.KEY_GAME_ID

enum class NavScreen{
    Home,
    Detail
}

@Composable
fun NavigationScreen(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel
) {
    NavHost(navController = navController,
        startDestination = NavScreen.Home.name){
        composable(NavScreen.Home.name){
            HomeScreen(gameViewModel = homeViewModel,
                onClickDetail = { navController.navigate(NavScreen.Detail.name) },
                modifier = Modifier)
        }
        composable(NavScreen.Detail.name){
            DetailedScreen(
                onBackClick = { navController.navigateUp() },
                gameViewModel = homeViewModel,
                modifier = Modifier,
                id = it.arguments?.getString(KEY_GAME_ID)?: "1"
            )
        }
    }
}

