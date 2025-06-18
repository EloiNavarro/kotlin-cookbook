package com.eloinavarro.coroutines.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopicList(paddingValues: PaddingValues, content: LazyListScope.() -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        content()
    }
}