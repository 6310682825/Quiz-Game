package com.example.quizapplication.ui.theme

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapplication.ui.theme

@Composable
fun GameScreen(viewModel: QuizlViewModel, onGameFinish: () -> Unit) {
    val gameStatus by viewModel.gameStatus.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Question ${gameStatus.currentQuestionIndex + 1} of 10",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = gameStatus.currentQuestion.question,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        val answers = gameStatus.currentQuestion.answers.shuffled()
        answers.forEach { answer ->
            AnswerButton(
                text = answer,
                isSelected = answer == gameStatus.selectedAnswer,
                isCorrect = answer == gameStatus.currentQuestion.correctAnswer,
                onClick = { viewModel.selectAnswer(answer) }
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.submitAnswer() },
            enabled = gameStatus.selectedAnswer != null
        ) {
            Text(text = "Submit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Score: ${gameStatus.score} / 10",
            fontSize = 20.sp
        )

        if (gameStatus.gameOver) {
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onGameFinish
            ) {
                Text(text = "Play Again")
            }
        }
    }
}

@Composable
fun AnswerButton(text: String, isSelected: Boolean, isCorrect: Boolean, onClick: () -> Unit) {
    val backgroundColor = when {
        isSelected && isCorrect -> Color.Green
        isSelected && !isCorrect -> Color.Red
        else -> MaterialTheme.colors.primary
    }

    val textColor = when {
        isSelected && isCorrect -> Color.White
        isSelected && !isCorrect -> Color.White
        else -> MaterialTheme.colors.onPrimary
    }

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor),
    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuizTheme {
        GameScreen(QuizViewModel(), {})
    }
}
