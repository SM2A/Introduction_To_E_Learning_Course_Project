package com.example.tsl.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.tsl.model.ExamCallback
import com.example.tsl.model.ExamItem
import com.example.tsl.ui.theme.*

@Composable
fun ExamView(
    item: ExamItem,
    callback: ExamCallback,
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
                        var btnColor by remember {
                            mutableStateOf(LIGHT_BLUE)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(PADDING_4)
                                .background(
                                    color = btnColor,
                                    shape = RoundedCornerShape(CORNER_RADIUS)
                                )
                                .border(
                                    width = BIRDER_WIDTH,
                                    color = DARK_BLUE,
                                    shape = RoundedCornerShape(CORNER_RADIUS)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = TRANSPARENT,
                                    contentColor = TRANSPARENT
                                ),
                                elevation = ButtonDefaults.elevation(
                                    defaultElevation = ELEVATION_0,
                                    pressedElevation = ELEVATION_0
                                ),
                                onClick = {
                                    btnColor = if (answers[it].second) {
                                        callback.onCorrectItemSelected()
                                        CORRECT_GREEN
                                    } else {
                                        callback.onWrongItemSelected()
                                        WRONG_RED
                                    }
                                },
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        top = PADDING_8,
                                        bottom = PADDING_8
                                    ),
                                    text = answers[it].first,
                                    fontSize = TITLE_FONT_SIZE,
                                    color = DARK_GRAY
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
