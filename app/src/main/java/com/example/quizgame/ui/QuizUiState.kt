package com.example.quizgame.ui

import com.example.quizgame.data.Questions
import com.example.quizgame.data.allQuestions

data class QuizUiState(
    val currentQuestion: Questions = allQuestions.random(),
    val questionCount: Int = 1,
    val score: Int = 0,
    val isGameOver: Boolean = false
)
