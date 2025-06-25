package com.eloinavarro.playground.ui.screens

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.eloinavarro.playground.R
import com.eloinavarro.playground.ui.common.Destination
import com.eloinavarro.playground.ui.common.HomeIcon
import com.eloinavarro.playground.ui.common.Screen
import com.eloinavarro.playground.ui.common.TopicCard
import com.eloinavarro.playground.ui.common.TopicList

@Composable
fun StartScreen(
    onNavigationItemClick: (Destination) -> Unit
) {
    Screen(
        title = "Kotlin playground",
        icon = { HomeIcon() }
    ) { paddingValues ->
        TopicList(paddingValues) {
            items(mainItems.size) { index ->
                TopicCard(
                    title = mainItems[index].title,
                    description = stringResource(mainItems[index].description),
                    onClick = { onNavigationItemClick(mainItems[index].destination) }
                )
            }
        }
    }
}

data class MainItem(
    val title: String,
    @StringRes val description: Int,
    val destination: Destination
)

val mainItems = listOf(
    MainItem("Coroutines", R.string.description_coroutines, Destination.Coroutines),
    MainItem("Coroutines", R.string.description_coroutines, Destination.Coroutines),
    MainItem("Coroutines", R.string.description_coroutines, Destination.Coroutines),
    MainItem("Coroutines", R.string.description_coroutines, Destination.Coroutines),
    MainItem("Coroutines", R.string.description_coroutines, Destination.Coroutines),
)