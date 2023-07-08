package com.example.tsl.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.tsl.model.ExamItem
import com.example.tsl.ui.theme.PADDING_8

@Composable
fun ExamView(
    item: ExamItem,
    modifier: Modifier = Modifier
) {
    val answers = item.answers.toList().shuffled()
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Traffic sign",
                modifier = Modifier
            )
            Text(
                text = item.question
            )
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(item.answers.size) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            modifier = Modifier.padding(top = PADDING_8, bottom = PADDING_8),
                            text = answers[it].first
                        )
                    }
                }
            }
        }
    }
}