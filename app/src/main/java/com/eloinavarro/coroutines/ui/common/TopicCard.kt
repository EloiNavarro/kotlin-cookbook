package com.eloinavarro.coroutines.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopicCard(
    title: String,
    description: String = "",
    onClick:()-> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Card(onClick = onClick) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(8.dp)
            )
            if(description.isNotEmpty()){
                Text(
                    text = description,
                    modifier = Modifier.padding(8.dp)
                )
            }
            content()
        }
    }
}