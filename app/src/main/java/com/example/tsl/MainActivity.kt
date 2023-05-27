package com.example.tsl

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LessonList(
                list = listOf(
                    "آزمون ورودی",
                    "تابلوهای دستوری",
                    "تابلوهای هشداری",
                    "تابلوهای اطلاعاتی",
                    "تابلوهای بازدازنده و انتظامی",
                    "تابلوهای آگاهی دهنده",
                    "تابلوهای راهنما مسیر",
                    "تابلوهای محلی",
                    "علائم جاده‌ای",
                    "علائم جاده‌ای1",
                    "2علائم جاده‌ای",
                    "3علائم جاده‌ای",
                    "4علائم جاده‌ای",
                    "آزمون نهایی",
                    "آزمون سنج یادگیری"
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
    list: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = list,
            key = { msg -> msg }
        ) {
            LessonItem(text = it)
        }
    }
}

@Composable
fun LessonItem(
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(
                color = Color(0xFFCEFF95),
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFF4CAF50),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(top = 8.dp, bottom = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            ),
            onClick = {
                Log.e("TAG", "LessonItem: $text")
            }
        ) {
            Text(
                text = text,
                fontSize = 32.sp,
                color = Color(0xFF525252)
            )
        }
    }
}