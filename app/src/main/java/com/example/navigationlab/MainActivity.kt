package com.example.navigationlab

import android.os.Bundle
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
        setContent {
            NavigationLabTheme {
                /**
                 * Here you will implement your
                 */
                val viewModel = hiltViewModel<ProductsViewModel>()
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}

