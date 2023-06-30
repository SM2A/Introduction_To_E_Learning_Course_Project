package com.example.tsl.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.tsl.model.content.*
import com.example.tsl.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LessonList(
                list = listOf(
                    EntryExam,
                    CautionarySigns,
                    IndicativeSigns,
                    DeterrentSigns,
                    RoadGuideSigns,
                    DomesticSigns,
                    ComplimentarySigns,
                    Labels,
                    FinalExam,
                    RememberExam
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun LessonList(
    list: List<ContentType>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = list,
            key = { msg -> msg.hashCode() }
        ) {
            LessonItem(item = it)
        }
    }
}

@Composable
fun LessonItem(
    item: ContentType
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PADDING_4)
            .background(
                color = LIGHT_GREEN,
                shape = RoundedCornerShape(CORNER_RADIUS)
            )
            .border(
                width = BIRDER_WIDTH,
                color = DARK_GREEN,
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
                val intent = Intent(
                    context,
                    if (item is Exam) ExamActivity::class.java else LessonActivity::class.java
                )
                intent.putExtra("className", item::class.java.simpleName)
                context.startActivity(intent)
            },
        ) {
            Text(
                modifier = Modifier.padding(top = PADDING_8, bottom = PADDING_8),
                text = item.title,
                fontSize = TITLE_FONT_SIZE,
                color = DARK_GRAY
            )
        }
    }
}
