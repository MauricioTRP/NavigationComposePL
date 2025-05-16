package com.example.navigationlab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.navigationlab.ui.AppNavigation
import com.example.navigationlab.ui.theme.NavigationLabTheme
import com.example.navigationlab.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /**
         * Check for any intents with data to navigate to
         */
        Log.d("MainActivity", "Intent data: ${intent.data}")

        setContent {
            NavigationLabTheme {
                /**
                 * Here you will use your navigation composable
                 */
                AppNavigation(intent = intent)
            }
        }
    }
}

