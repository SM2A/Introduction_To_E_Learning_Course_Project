package com.example.tsl.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
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

        setContent {
            val index = viewModel.itemIndex.collectAsState()
            val showNextBtn = (index.value + 1) < viewModel.data.lessonContent.size
            val showPrevBtn = index.value >= 0
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                if (showNextBtn && showPrevBtn) {
                    LessonContentItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.8f),
                        description = viewModel.getItem().description,
                        image = viewModel.getItem().image
                    )
                }
                NavigationButtons(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    nextAction = {
                        viewModel.nextItem()
                    },
                    prevAction = {
                        viewModel.previousItem()
                    },
                    showNext = showNextBtn,
                    showPrev = showPrevBtn
                )
            }
        }
    }

}

@Composable
fun LessonContentItem(
    description: String,
    image: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Traffic sign",
            modifier = Modifier
        )
        Text(
            text = description
        )
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
