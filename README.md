# Jetpack Compose Timer App

This Android app demonstrates a 1-minute countdown timer using Jetpack Compose, ViewModel with StateFlows, and Koin for dependency injection. The app includes an animated ring around the text and buttons indicating the current state of the timer. Additionally, the app posts a system notification when the timer reaches zero, even if the app is in the background.

## Features
1. Display of the current timer value in minutes, seconds, and milliseconds.
2. Start/Pause and Stop buttons to control the timer.
3. Animated ring around the text and buttons to visualize the timer state.
4. Proper functionality of the timer even when the app is in the background.
5. Use of Flows/StateFlows in the ViewModel for implementing logic.
6. Dependency injection with Koin for creating the ViewModel.
7. System notification when the timer reaches zero, regardless of the app's state.

## Tech Stack

- Jetpack Compose
- ViewModel with Flows/StateFlows
- Koin for Dependency Injection

## Project Structure

The project follows the standard Android project structure:

- `app`: Main Android application module.
    - `src/main/java`: Contains the main application code.
        - `com.mukesh.componsetask`: Package for the application.
            - `di`: Contains Koin modules for dependency injection.
            - `ui`: It Contain Screens, Application Class, Main Class, App Themes.
              - `components`:  This folder contain common UI components.
              - `state`: It contain Different TimerState sealed class with time format function.
            - `notification`: It contain common function for show notification when timer complete..


## Video Playback

To see the app in action, check out the [App Video](https://drive.google.com/file/d/1XU0y5Hkbfvqgf_g1kWi91aOkT57pj5fC/view?usp=sharing).

[Watch Video](https://drive.google.com/file/d/1XU0y5Hkbfvqgf_g1kWi91aOkT57pj5fC/view?usp=sharing)



<b><h3>Thank you for your support.</h3></b>
