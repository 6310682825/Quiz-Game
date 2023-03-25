package com.example.quizgame.ui

import com.example.quizgame.data.Questions

data class QuizUiState(
    val currentQuestion: Questions = Questions("", listOf(""), "")
)
