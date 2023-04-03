package com.example.quizgame.data

const val MAX_NO_OF_QUESTIONS = 10
const val SCORE_INCREASE = 20

// Set with all the words for the Game
val allQuestions: Set<Questions> =
    setOf(
        Questions(
            "What is the square root of 16?",
            listOf("2", "4", "6", "8"),
            "4"
        ),
        Questions(
            "What is the capital of France?",
            listOf("Madrid", "Paris", "London", "Berlin"),
            "Paris"
        ),
        Questions(
            "What is the tallest mountain in the world?",
            listOf("Mount Everest", "K2", "Kilimanjaro", "Denali"),
            "Mount Everest"
        ),
        Questions(
            "What is the largest planet in our solar system?",
            listOf("Jupiter", "Saturn", "Neptune", "Mars"),
            "Jupiter"
        ),
        Questions(
            "What is the smallest country in the world?",
            listOf("Vatican City", "Monaco", "Nauru", "Liechtenstein"),
            "Vatican City"
        ),
        Questions(
            "What is the chemical symbol for gold?",
            listOf("Go", "Ag", "Au", "Cu"),
            "Au"
        ),
        Questions(
            "What is the boiling point of water?",
            listOf("100°C", "0°C", "50°C", "200°C"),
            "100°C"
        ),
        Questions(
            "What is the largest organ in the human body?",
            listOf("Liver", "Lungs", "Heart", "Skin"),
            "Skin"
        ),
        Questions(
            "What is the currency of Japan?",
            listOf("Yuan", "Yen", "Dollar", "Won"),
            "Yen"
        ),
        Questions(
            "What is 2+2?",
            listOf("3", "4", "5", "6"),
            "4"
        )
    )