package com.example.quizgame.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizgame.ui.theme.QuizGameTheme
import com.example.quizgame.R
import java.time.format.TextStyle

@Preview(showBackground = true)
@Composable
fun QuizScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        QuizStatus()
        QuizLayout()
        Row(){
            OutlinedButton(onClick = { /*TODO*/ },
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
}

@Composable
fun QuizStatus(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .size(48.dp)
    ) {
        Text(
            text = stringResource(R.string.quiz_count, 1)
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            text = stringResource(id = R.string.score, 0)
        )

    }
}

@Composable
fun QuizLayout(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "word",
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(R.string.instruction),
            fontSize = 16.sp,

        )
        Spacer(modifier = modifier.height(16.dp))
        AnswerButton()
    }
}

@Composable
fun AnswerButton(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = { /*TODO*/ },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = "1",
                fontSize = 24.sp
            )
        }
        Button(onClick = { /*TODO*/ },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = "2",
                fontSize = 24.sp
            )
        }
        Button(onClick = { /*TODO*/ },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = "3",
                fontSize = 24.sp
            )
        }
        Button(onClick = { /*TODO*/ },
            modifier = modifier.width(240.dp)
            ) {
            Text(
                text = "4",
                fontSize = 24.sp
            )
        }
    }
}