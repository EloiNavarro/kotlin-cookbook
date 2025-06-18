package com.eloinavarro.coroutines.ui.utils

import android.content.Context
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodeBlock(filename: String, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val code = remember(filename) {
        loadAsset(context, filename)
    }
    Surface(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(6.dp),
        color = Color(0xFF2E3440),
        tonalElevation = 2.dp
    ) {
        Box(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(8.dp)
        ){
            Text(
                text = code,
                maxLines = Int.MAX_VALUE,
                softWrap = false,
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp,
                color = Color(0xFFECEFF4),
                lineHeight = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

private fun loadAsset(context: Context, filename: String): String {
    return context.assets.open(filename).bufferedReader().use { it.readText() }
}