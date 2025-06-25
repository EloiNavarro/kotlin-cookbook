package com.eloinavarro.playground.ui.common

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PlaygroundApplication() {
    val navController = rememberNavController()
    Navigation(navController = navController)
}