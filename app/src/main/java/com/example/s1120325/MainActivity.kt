package com.example.s1120325

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.s1120325.ui.theme.S1120325Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppContent()
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }
    }


@Composable
fun AppContent() {
    val colors = listOf(
        Color(0xff95fe95),
        Color(0xfffdca0f),
        Color(0xfffea4a4),
        Color(0xffa5dfed)
    )

    val currentColorIndex = remember { mutableStateOf(0) }

    var offsetX by remember { mutableStateOf(0f) }
    var isDragging by remember { mutableStateOf(false) }

    val draggableState = rememberDraggableState { delta ->
        offsetX += delta
    }

    LaunchedEffect(offsetX) {
        if (!isDragging) {
            if (offsetX > 100) {
                currentColorIndex.value = (currentColorIndex.value + 1) % colors.size
            } else if (offsetX < -100) {
                currentColorIndex.value = (currentColorIndex.value - 1 + colors.size) % colors.size
            }
            offsetX = 0f
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors[currentColorIndex.value])
            .draggable(
                state = draggableState,
                orientation = Orientation.Horizontal,
                onDragStarted = { isDragging = true },
                onDragStopped = { isDragging = false }
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("2024期末上機考(資管二B林政彥)")

            Image(
                painter = painterResource(id = R.drawable.class_b),
                contentDescription = "B班同學"
            )

            Text("遊戲持續時間 0 秒")

            Text("您的成績 0 分")

            Button(onClick = {
                finishApp()
            }) {
                Text("結束App")
            }
        }
    }
}

fun finishApp() {
    android.os.Process.killProcess(android.os.Process.myPid())
}