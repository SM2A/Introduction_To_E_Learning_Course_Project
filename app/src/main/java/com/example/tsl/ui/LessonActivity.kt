package com.example.tsl.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import com.example.tsl.R
import com.example.tsl.model.content.Lesson
import com.example.tsl.util.getDataFromName
import com.example.tsl.viewmodel.LessonViewModel

class LessonActivity : ComponentActivity() {

    private val viewModel: LessonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.data = getDataFromName(intent.getStringExtra("className")) as Lesson

        viewModel.itemIndex.observe(this) {
            if (it >= 0) {

            }
        }

        setContent {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                NavigationButtons(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.2f),
                    nextAction = {
                        viewModel.nextItem()
                    },
                    prevAction = {
                        viewModel.previousItem()
                    }
                )
            }
        }
    }

}

@Composable
fun NavigationButtons(
    nextAction: () -> Unit,
    prevAction: () -> Unit,
    modifier: Modifier = Modifier,
    showNext: Boolean = true,
    showPrev: Boolean = true
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DirectionButton(
            modifier = Modifier
                .fillMaxHeight()
                .rotate(180f)
                .weight(1f),
            isVisible = showPrev,
            onClickAction = {
                prevAction.invoke()
            }
        )
        DirectionButton(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            isVisible = showNext,
            onClickAction = {
                nextAction.invoke()
            }
        )
    }
}

@Composable
fun DirectionButton(
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier,
    isVisible: Boolean = true
) {
    if (isVisible) {
        Image(
            painter = painterResource(
                id = R.drawable.baseline_navigate_next_24
            ),
            contentDescription = "Navigation button",
            modifier = modifier.clickable {
                onClickAction.invoke()
            }
        )
    }
}
