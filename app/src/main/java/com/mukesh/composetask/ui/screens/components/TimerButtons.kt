package com.mukesh.composetask.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.mukesh.composetask.ui.screens.state.TimerState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TimerButtons(timerState: TimerState, startTimerClick: () -> Unit, stopTimerClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        val keyboardController = LocalSoftwareKeyboardController.current

        IconButton(
            onClick = { startTimerClick() },
            modifier = Modifier
                .size(56.dp)
                .background(
                    if (timerState is TimerState.Running) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.primary
                    }
                )
                .clip(CircleShape)
        ) {
            Icon(
                imageVector = if (timerState is TimerState.Running) {
                    Icons.Default.Pause
                } else {
                    Icons.Default.PlayArrow
                },
                contentDescription = null,
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        IconButton(
            onClick = { stopTimerClick() },
            modifier = Modifier
                .size(56.dp)
                .background(MaterialTheme.colorScheme.primary)
                .clip(CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Stop,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}