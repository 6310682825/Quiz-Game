package com.example.quizapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapplication.ui.theme.QuizViewModel
import com.example.quizgame

class MainActivity : AppCompatActivity() {

    private val viewModel = QuizViewModel()

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizApp(viewModel)
        }
    }
}

@Composable
fun QuizApp(viewModel: QuizViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quiz Game") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            )
        },
        content = {
            QuizScreen(viewModel)
        }
    )
}

@Composable
fun QuizScreen(viewModel: QuizViewModel) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Question 1 of 10")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "What is 2 + 2?")
        Spacer(modifier = Modifier.height(16.dp))
        AnswerOption(text = "2", selected = false, onSelect = {})
        Spacer(modifier = Modifier.height(8.dp))
        AnswerOption(text = "3", selected = false, onSelect = {})
        Spacer(modifier = Modifier.height(8.dp))
        AnswerOption(text = "4", selected = false, onSelect = {})
        Spacer(modifier = Modifier.height(8.dp))
        AnswerOption(text = "5", selected = false, onSelect = {})
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {}) {
            Text(text = "Next")
        }
    }
}

@Composable
fun AnswerOption(text: String, selected: Boolean, onSelect: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp,
        onClick = onSelect,
        color = if (selected) MaterialTheme.colors.secondary else MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            RadioButton(selected = selected, onClick = onSelect)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizAppPreview() {
    QuizApp(QuizViewModel())
}
