package com.eloinavarro.playground.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.eloinavarro.playground.ui.theme.PlaygroundTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(
    title: String,
    icon: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    PlaygroundTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = icon
                )
            },
        ) { padding ->
            content(padding)
        }
    }
}

@Composable
fun ArrowBackIcon(onUpClick: () -> Unit) {
    IconButton(onClick = onUpClick) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Go back arrow"
        )
    }
}

@Composable
fun HomeIcon() {
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "This is the starting screen"
        )
    }
}