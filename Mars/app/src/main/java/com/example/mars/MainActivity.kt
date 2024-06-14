package com.example.mars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mars.ui.MarsApp
import com.example.mars.ui.theme.MarsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MarsApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarsPreview() {
    MarsTheme {
        MarsApp()
    }
}