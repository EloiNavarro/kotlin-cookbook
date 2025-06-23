package com.eloinavarro.coroutines.ui.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eloinavarro.coroutines.ui.screens.CoroutinesScreen
import com.eloinavarro.coroutines.ui.screens.DispatchersScreen
import com.eloinavarro.coroutines.ui.screens.StartScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.Start
    ) {
        start(navController)
        coroutines(navController)
    }
}

private fun NavGraphBuilder.start(navController: NavController) {
    composable<Destination.Start> {
        StartScreen(onNavigationItemClick = { destination -> navController.navigate(destination) })
    }
}

private fun NavGraphBuilder.coroutines(navController: NavController) {
    composable<Destination.Coroutines> {
        CoroutinesScreen(
            onUpClick = { navController.popBackStack() },
            onDetailClick = { destination -> navController.navigate(destination) }
        )
    }
    composable<Destination.Dispatchers> {
        DispatchersScreen(
            onUpClick = { navController.popBackStack() }
        )
    }
}

sealed interface Destination {
    @Serializable
    object Start : Destination

    @Serializable
    object Coroutines : Destination

    @Serializable
    object Dispatchers : Destination
}