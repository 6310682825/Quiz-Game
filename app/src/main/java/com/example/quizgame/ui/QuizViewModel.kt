package com.example.quizgame.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.quizgame.data.Questions
import com.example.quizgame.data.allQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuizViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(QuizUiState())
    private lateinit var currentQuestion: Questions
    private var questionsAsked: MutableSet<Questions> = mutableSetOf()
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    init {
        resetGame()
    }
    private fun pickRandomQuestion(): Questions {
        currentQuestion = allQuestions.random()
        for (question in questionsAsked) {
            if (question.text === currentQuestion.text) {
                Log.i("test","questions asked")
                return pickRandomQuestion()
            }
        }
        questionsAsked.add(currentQuestion)
        return shuffleOption(currentQuestion)
    }

    private fun shuffleOption(question: Questions): Questions {
        question.options = question.options.shuffled()
        return question
    }

    private fun updateQuizState(updatedScore: Int) {
        if (questionsAsked.size == 10) {
            _uiState.update { currentQuestion ->
                currentQuestion.copy(
                    score = updatedScore,
                    isGameOver = true
                )
            }
        }
        else {
            _uiState.update { currentQuestion ->
                currentQuestion.copy(
                    currentQuestion = pickRandomQuestion(),
                    score = updatedScore,
                    questionCount = currentQuestion.questionCount.inc()
                )
            }
        }
    }

    fun skipQuestion() {
        updateQuizState(_uiState.value.score)
    }
    fun checkAnswer(guess: String, answer:String) {
        val updatedScore: Int
        if (guess === answer) {
            updatedScore = _uiState.value.score.plus(10)
        }
        else {
            updatedScore = _uiState.value.score.minus(5)
        }
        updateQuizState(updatedScore)
    }
    fun resetGame() {
        questionsAsked.clear()
        _uiState.value = QuizUiState(currentQuestion = pickRandomQuestion())
    }
}