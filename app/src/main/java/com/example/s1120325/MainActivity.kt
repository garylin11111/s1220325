package com.example.s1120325

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff95fe95)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("2024期末上機考(資管二B林政彥)")

            Image(
                painter = painterResource(id = R.drawable.class_a),
                contentDescription = "Class Image"
            )

            Text("遊戲持續時間 0 秒")

            Text("您的成績 0 分")

            Button(onClick = {
                finishApp() }) {
                Text("結束App")
            }
        }
    }
}
fun finishApp() {
    android.os.Process.killProcess(android.os.Process.myPid())
}
