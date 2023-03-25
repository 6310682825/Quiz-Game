package com.example.quizgame.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class QuizViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(QuizUiState())
}