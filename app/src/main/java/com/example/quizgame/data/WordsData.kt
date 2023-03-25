package com.example.quizgame.data

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

// Set with all the words for the Game
val allQuestions: Set<Questions> =
    setOf(
        Questions(
            "What is the square root of 16?",
            listOf("2", "4", "6", "8"),
            "1"
        ),
        Questions(
            "What is the capital of France?",
            listOf("Madrid", "Paris", "London", "Berlin"),
            "1"
        ),
        Questions(
            "What is the tallest mountain in the world?",
            listOf("Mount Everest", "K2", "Kilimanjaro", "Denali"),
            "0"
        ),
        Questions(
            "What is the largest planet in our solar system?",
            listOf("Jupiter", "Saturn", "Neptune", "Mars"),
            "0"
        ),
        Questions(
            "What is the smallest country in the world?",
            listOf("Vatican City", "Monaco", "Nauru", "Liechtenstein"),
            "0"
        ),
        Questions(
            "What is the chemical symbol for gold?",
            listOf("Go", "Ag", "Au", "Cu"),
            "2"
        ),
        Questions(
            "What is the boiling point of water?",
            listOf("100°C", "0°C", "50°C", "200°C"),
            "0"
        ),
        Questions(
            "What is the largest organ in the human body?",
            listOf("Liver", "Lungs", "Heart", "Skin"),
            "3"
        ),
        Questions(
            "What is the currency of Japan?",
            listOf("Yuan", "Yen", "Dollar", "Won"),
            "1"
        ),
        Questions(
            "What is 2+2?",
            listOf("3", "4", "5", "6"),
            "1"
        )
    )