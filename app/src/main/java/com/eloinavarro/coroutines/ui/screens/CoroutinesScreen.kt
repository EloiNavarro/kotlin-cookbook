package com.eloinavarro.coroutines.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eloinavarro.coroutines.R
import com.eloinavarro.coroutines.ui.common.ArrowBackIcon
import com.eloinavarro.coroutines.ui.common.Destination
import com.eloinavarro.coroutines.ui.common.Screen
import com.eloinavarro.coroutines.ui.common.TopicCard
import com.eloinavarro.coroutines.ui.common.TopicList
import com.eloinavarro.coroutines.ui.utils.CodeBlock

@Composable
fun CoroutinesScreen(
    onUpClick: () -> Unit,
    onDetailClick: (Destination) -> Unit
) {
    Screen(
        title = "Coroutines",
        icon = { ArrowBackIcon(onUpClick) }
    ) { paddingValues ->
        TopicList(paddingValues) {
            items(coroutines.size) { index ->
                TopicCard(
                    title = coroutines[index].title,
                    description = stringResource(coroutines[index].description),
                    onClick = { coroutines[index].destination?.let { onDetailClick(it) } }
                ) {
                    CodeBlock(
                        filename = coroutines[index].filename,
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 100.dp)
                    )
                }
            }
        }
    }
}

data class CoroutineTopic(
    val title: String,
    @StringRes val description: Int,
    val filename: String,
    val isOpen: Boolean = false,
    val destination: Destination? = null
)

val coroutines = listOf(
    CoroutineTopic("Basic", R.string.coroutine_basic_description, filename = "basic.kt"),
    CoroutineTopic("Suspend", R.string.coroutine_suspend_description, filename = "suspend.kt"),
    CoroutineTopic("Dispatchers", R.string.coroutine_dispatchers_description, filename = "dispatchers.kt", destination = Destination.Dispatchers),
)