package com.example.quizgame.ui

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizgame.R
import com.example.quizgame.data.Questions

@Preview(showBackground = true)
@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    quizViewModel: QuizViewModel = viewModel()
    ) {
    val quizUiState by quizViewModel.uiState.collectAsState()
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        QuizStatus(questionCount = quizUiState.questionCount,
            score = quizUiState.score
            )
        QuizLayout(currentQuestion = quizUiState.currentQuestion, view = quizViewModel)
        Row{
            OutlinedButton(onClick = { quizViewModel.skipQuestion() },
                modifier = modifier.width(180.dp)
                ) {
                Text(
                    text = stringResource(id = R.string.skip),
                    fontSize = 24.sp,
                    modifier = modifier.padding(16.dp)
                )
            }
        }
    }
    if (quizUiState.isGameOver) {
        FinalScoreDialog(score = quizUiState.score, onPlayAgain = { quizViewModel.resetGame() })
    }
}

@Composable
fun QuizStatus(questionCount: Int, score: Int,
    modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .size(48.dp)
    ) {
        Text(
            text = stringResource(R.string.quiz_count, questionCount)
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            text = stringResource(id = R.string.score, score)
        )

    }
}

@Composable
fun QuizLayout(
    currentQuestion: Questions,
    view: QuizViewModel,
    modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = currentQuestion.text,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(R.string.instruction),
            fontSize = 16.sp,

        )
        Spacer(modifier = modifier.height(16.dp))
        AnswerButton(options = currentQuestion.options, answer = currentQuestion.answer, view)
    }
}

@Composable
fun AnswerButton(options: List<String>,
                 answer: String,
                 view: QuizViewModel,
    modifier: Modifier = Modifier
    )
    {

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = { view.checkAnswer(options[0], answer) },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = options[0],
                fontSize = 24.sp
            )
        }
        Button(onClick = { view.checkAnswer(options[1], answer) },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = options[1],
                fontSize = 24.sp
            )
        }
        Button(onClick = { view.checkAnswer(options[2], answer) },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = options[2],
                fontSize = 24.sp
            )
        }
        Button(onClick = { view.checkAnswer(options[3], answer) },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = options[3],
                fontSize = 24.sp
            )
        }
    }
}

@Composable
private fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(onDismissRequest = { /*TODO*/ },
        title = { Text(stringResource(R.string.game_over))},
        text = { Text(stringResource(R.string.final_score, score))},
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = { activity.finish() }) {
                Text(text = stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(onClick = { onPlayAgain }) {
                Text(stringResource(R.string.play_again))
            }
        }
    )
}