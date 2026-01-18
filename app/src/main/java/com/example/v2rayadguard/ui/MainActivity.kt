package com.example.v2rayadguard.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.v2rayadguard.vm.MainViewModel
import com.example.v2rayadguard.ui.theme.V2RayAdGuardTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            V2RayAdGuardTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen(viewModel)
                }
            }
        }
    }

    @Composable
    fun MainScreen(viewModel: MainViewModel) {
        // TODO: Implement the main screen UI
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        V2RayAdGuardTheme {
            MainScreen(viewModel)
        }
    }
}