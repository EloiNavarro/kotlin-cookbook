package com.eloinavarro.playground.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.eloinavarro.playground.R
import com.eloinavarro.playground.ui.common.ArrowBackIcon
import com.eloinavarro.playground.ui.common.Screen
import com.eloinavarro.playground.ui.common.TopicCard
import com.eloinavarro.playground.ui.common.TopicList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun DispatchersScreen(
    onUpClick: () -> Unit,
) {
    Screen(
        title = "Dispatchers",
        icon = { ArrowBackIcon(onUpClick) }
    ) { paddingValues ->
        TopicList(paddingValues) {
            items(actions.size) { index ->
                TopicCard(
                    title = actions[index].title,
                    description = stringResource(actions[index].description)
                ) {
                    TaskButton(actions[index].label, actions[index].action)
                }
            }
        }
    }
}

data class DispatchersActions(
    val title: String,
    val label: String,
    @StringRes val description: Int,
    val action: suspend () -> String
)

val actions = listOf(
    DispatchersActions(
        title = "Dispatchers.Default",
        label = "Do CPU task",
        description = R.string.coroutine_default_dispatcher,
        ::doCpuIntensiveTask
    ),
    DispatchersActions(
        title = "Dispatchers.IO",
        label = "Do I/O task",
        description = R.string.coroutine_io_dispatcher,
        ::doIoIntensiveTask
    ),
)

@Composable
fun TaskButton(label: String, action: suspend () -> String = { "" }) {
    val scope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf<String?>(null) }
    Button(
        onClick = {
            if (isLoading) return@Button
            isLoading = true
            result = ""
            scope.launch {
                result = action()
                isLoading = false
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(label)
    }
    result?.let {
        Text(result!!)
    }
    if (isLoading) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

private suspend fun doCpuIntensiveTask(): String = withContext(Dispatchers.Default) {
    var result = 0
    for (i in 1..1_000) {
        result += i
        delay(1L)
    }
    "Result: $result"
}

private suspend fun doIoIntensiveTask(): String = withContext(Dispatchers.IO) {
    delay(2000L)
    "Result: I/O intensive task done"
}