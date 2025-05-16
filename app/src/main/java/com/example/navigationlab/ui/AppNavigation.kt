package com.example.navigationlab.ui

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.example.navigationlab.Destinations
import com.example.navigationlab.ui.screens.HomeScreen
import com.example.navigationlab.ui.screens.ProductDetailsScreen
import com.example.navigationlab.ui.theme.NavigationLabTheme

const val DEEP_LINK_URI_SCHEME = "navigationcodelab"

@Composable
fun AppNavigation(/*intent: Intent? = null*/) {
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
                 * Intent Handling for Deep Links
                 */
                val intent = LocalContext.current.intent
                handleDeepLink(intent, navController)

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
                    )
                }

                composable <Destinations.ProductDetails>(
                    deepLinks = listOf(
                        navDeepLink <Destinations.ProductDetails>(
                            basePath = "$DEEP_LINK_URI_SCHEME/products"
                        )
                    )
                ) { backStackEntry ->
                    val productDestination = backStackEntry.toRoute<Destinations.ProductDetails>()

                    Log.d("AppNavigation", "ProductDetails: ${productDestination.productId}")

                    ProductDetailsScreen(
                        productId = productDestination.productId
                    )
                }


            }
        }
    }
}

/**
 * Handles the intent that launched the app and navigates to the appropriate destination based on the intent data.
 *
 * ```kotlin
 *
 *
 * ```
 *
 * @param intent The intent that launched the app.
 * @param navController The navigation controller used to navigate between destinations.
 */
private fun handleDeepLink(intent: Intent?, navController: NavHostController) {
    intent?.data?.let { uri ->
        val productId = uri.getQueryParameter("productId")?.toIntOrNull()
        if (productId != null) {
            // Navigate to ProductDetails screen with productId
             navController.navigate(Destinations.ProductDetails(productId))
        }

    }
}
