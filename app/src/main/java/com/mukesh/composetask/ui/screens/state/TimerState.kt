package com.mukesh.composetask.ui.screens.state

sealed class TimerState {
    data object Initial : TimerState()
    data class Running(val timeRemaining: Long) : TimerState()
    data class Paused(val timeRemaining: Long) : TimerState()
    data object Finished : TimerState()
    data class ClearData(val timeRemaining: Long): TimerState()

    val displayValue: String
        get() = when (this) {
            is Initial -> "00:00:000"
            is Running -> formatTime(timeRemaining)
            is Paused -> formatTime(timeRemaining)
            is Finished -> "00:00:000"
            is ClearData -> "00:00:000"
        }

    private fun formatTime(time: Long): String {
        val minutes = (time / 60000) % 60
        val seconds = (time / 1000) % 60
        val milliseconds = time % 1000
        return String.format("%02d:%02d:%03d", minutes, seconds, milliseconds)
    }
}