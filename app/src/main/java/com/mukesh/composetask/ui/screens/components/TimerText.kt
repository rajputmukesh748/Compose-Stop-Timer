package com.mukesh.composetask.ui.screens.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mukesh.composetask.ui.screens.state.TimerState

@Composable
fun TimerText(maxProgress: Long, currentProgress: Long, timerState: TimerState) {
    val progress = currentProgress.toDouble().div(maxProgress.toDouble()) * 100
    Log.e("ProgressValue", "$maxProgress - $currentProgress - $progress")
    Box(
        modifier = Modifier.size(200.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize(),
            trackColor = Color.LightGray,
            progress = progress.div(100).toFloat()
        )
        Text(
            text = timerState.displayValue,
            style = MaterialTheme.typography.displayMedium,
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(24.dp)
                .clip(CircleShape)
                .padding(16.dp)
        )
    }
}