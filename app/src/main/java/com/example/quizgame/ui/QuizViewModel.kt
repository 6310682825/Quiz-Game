package com.example.quizgame.ui

import androidx.lifecycle.ViewModel
import com.example.quizgame.data.Questions
import com.example.quizgame.data.allQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel : ViewModel() {

    init {
        resetGame()
    }
    private val _uiState = MutableStateFlow(QuizUiState())
    private lateinit var currentQuestion: Questions
    private var questionsAsked: MutableSet<Questions> = mutableSetOf()
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private fun pickRandomQuestion(): Questions {
        currentQuestion = allQuestions.random()
        if (questionsAsked.contains(currentQuestion)) {
            return pickRandomQuestion()
        } else {
            questionsAsked.add(currentQuestion)
            return shuffleOption(currentQuestion)
        }
    }

    private fun shuffleOption(question: Questions): Questions {
        question.options = question.options.shuffled()
        return question
    }

    fun resetGame() {
        questionsAsked.clear()
        _uiState.value = QuizUiState(currentQuestion = pickRandomQuestion())
    }
}