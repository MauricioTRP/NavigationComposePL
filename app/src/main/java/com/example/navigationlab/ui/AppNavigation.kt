package com.example.navigationlab.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.navigationlab.Destinations
import com.example.navigationlab.ui.screens.HomeScreen
import com.example.navigationlab.ui.screens.ProductDetailsScreen
import com.example.navigationlab.ui.theme.NavigationLabTheme
import com.example.navigationlab.viewmodel.ProductsViewModel

@Composable
fun AppNavigation(viewModel: ProductsViewModel) {
    NavigationLabTheme {
        /**
         * First we need to define our [androidx.navigation.NavHostController]
         * which is the main source of truth for navigation between composables
         *
         * On our top level composable we define our [NavHost] composable
         * which displays the current destination of our [NavGraph]
         */
        var currentScreen : Destinations by remember { mutableStateOf(Destinations.Home) }
        val navController = rememberNavController()

        Scaffold { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Destinations.Home,
                modifier = Modifier.padding(innerPadding)
            ) {
                /**
                 * Inside our NavHost, we'll define the NavGraph
                 * using [composable]
                 */
                composable<Destinations.Home> {
                    /* Our composable to be shown on this node on [NavGraph] */

                    HomeScreen(
                        onProductClick = { product ->
                            navController.navigate(Destinations.ProductDetails(product.id))
                        },
                        productsViewModel = viewModel
                    )
                }

                composable<Destinations.ProductDetails> { backStackEntry ->
                    val productDestination = backStackEntry.toRoute<Destinations.ProductDetails>()
                    ProductDetailsScreen(
                        viewModel = viewModel,
                        productId = productDestination.productId
                    )
                }
            }
        }
    }
}