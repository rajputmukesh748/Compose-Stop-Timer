package com.mukesh.composetask.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukesh.composetask.ui.screens.components.TimerButtons
import com.mukesh.composetask.ui.screens.components.TimerText
import org.koin.androidx.compose.koinViewModel

@Composable
fun TimerScreen(viewModel: TimerViewModel = koinViewModel()) {

    val timerState = viewModel.timerState.collectAsState()

    Log.e("Sdfsdfsd","------  ${timerState.value.displayValue}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TimerText(maxProgress = viewModel.maxTime,currentProgress = viewModel.currentTime, timerState = timerState.value)
        Spacer(modifier = Modifier.height(16.dp))
        TimerButtons(timerState.value, startTimerClick = {
            viewModel.startPauseTimer()
        }, stopTimerClick = {
            viewModel.stopTimer()
        })
    }
}


@Preview
@Composable
fun PreviewTimerScreen() {
    TimerScreen()
}