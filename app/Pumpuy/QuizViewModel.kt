package com.example.quizapplication.ui.theme

import Question
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = -1
    private var score = 0

    init {
        // Add your math questions here
        questions.addAll(
            listOf(
                Question("What is 2 + 2?", listOf("1", "2", "3", "4"), 3),
                Question("What is 10 / 2?", listOf("2", "5", "8", "10"), 1),
                Question("What is 3 * 4?", listOf("7", "9", "10", "12"), 3),
                Question("What is 8 - 3?", listOf("3", "4", "5", "6"), 2),
                // Add more questions here
            )
        )
        questions.shuffle()
    }

    fun getCurrentQuestion(): Question? {
        return if (currentQuestionIndex < 0 || currentQuestionIndex >= questions.size) {
            null
        } else {
            questions[currentQuestionIndex]
        }
    }

    fun selectAnswer(answerIndex: Int): Boolean {
        val currentQuestion = getCurrentQuestion()
        return if (currentQuestion != null && currentQuestion.answer == answerIndex) {
            score++
            true
        } else {
            false
        }
    }

    fun getNextQuestion(): Boolean {
        currentQuestionIndex++
        return currentQuestionIndex < questions.size
    }

    fun getScore(): Int {
        return score
    }

    fun reset() {
        currentQuestionIndex = -1
        score = 0
        questions.shuffle()
    }
}
