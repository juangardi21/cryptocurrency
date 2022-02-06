package com.android.cryptocurrency.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.cryptocurrency.ui.screens.coinDetail.components.CoinDetailScreen
import com.android.cryptocurrency.ui.screens.coinList.components.CoinListScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.CoinListScreen.route,
    ) {

        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(
                navigate = { coin ->
                    navHostController.navigate("${Screen.CoinDetailScreen.route}/${coin.id}")
                }
            )
        }

        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
            CoinDetailScreen()
        }
    }
}