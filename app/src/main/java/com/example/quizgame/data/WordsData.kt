package com.example.quizgame.data

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

// Set with all the words for the Game
val allQuestions: Set<Questions> =
    setOf(
        Questions(
            "Test1",
            listOf("A1", "A2,", "A3", "A4"),
            "A1"
        ),
        Questions(
            "Test2",
            listOf("A1", "A2,", "A3", "A4"),
            "A4"
        ),
        Questions(
            "Test3",
            listOf("A1", "A2,", "A3", "A4"),
            "A4"
        ),
        Questions(
            "Test4",
            listOf("A2", "A2,", "A3", "A4"),
            "A1"
        ),
    )