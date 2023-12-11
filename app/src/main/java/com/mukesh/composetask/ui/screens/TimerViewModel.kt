package com.mukesh.composetask.ui.screens

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mukesh.composetask.notification.showTimerCompleteNotification
import com.mukesh.composetask.ui.ApplicationController
import com.mukesh.composetask.ui.screens.state.TimerState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {

    private val _timerState = MutableStateFlow<TimerState>(TimerState.Initial)
    val timerState: StateFlow<TimerState> get() = _timerState.asStateFlow()

    val maxTime: Long = 60000 //1 Min
    var currentTime: Long = 0L
    private var stopTime: Long = 0L
    private var countDownTimer: CountDownTimer? = null


    fun startPauseTimer() {
        when (_timerState.value) {
            is TimerState.Initial -> {
                startTimer()
            }
            is TimerState.Running -> {
                pauseTimer()
            }
            is TimerState.Paused -> {
                resumeTimer()
            }
            is TimerState.Finished -> {
            }
            is TimerState.ClearData -> {
                clearData()
            }
        }
    }

    fun stopTimer() {
        countDownTimer?.cancel()
        _timerState.update { TimerState.ClearData(0L) }
        clearData()
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(maxTime - currentTime, 100) {
            override fun onTick(long: Long) {
                currentTime = maxTime - long
                _timerState.update { TimerState.Running(maxTime + currentTime - maxTime) }
            }

            override fun onFinish() {
                _timerState.update { TimerState.Finished }
                showTimerCompleteNotification(ApplicationController.context?.get())
                clearData()
            }
        }.start()
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
        stopTime = currentTime
        _timerState.update { TimerState.Paused(currentTime) }
    }

    private fun resumeTimer() {
        startTimer()
    }


    private fun clearData(){
        currentTime = 0
        stopTime = 0
        countDownTimer = null
    }

    override fun onCleared() {
        super.onCleared()
        countDownTimer?.cancel()
    }
}