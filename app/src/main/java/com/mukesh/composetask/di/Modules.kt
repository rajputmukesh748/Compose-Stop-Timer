package com.mukesh.composetask.di

import com.mukesh.composetask.ui.screens.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val timerModule = module {
    viewModel { TimerViewModel() }
}