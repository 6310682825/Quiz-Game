package com.example.quizgame.data

data class Questions(
    val text: String,
    var options: List<String>,
    val answer: String
    )
