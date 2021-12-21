package com.repele.boilerplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.repele.boilerplate.presentation.composable.screen.ScreenPictureDetails
import com.repele.boilerplate.presentation.composable.screen.UsersGridScreen
import com.repele.boilerplate.ui.theme.BoilerplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoilerplateTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "grid") {

                    // Grid of users
                    composable("grid") {
                        UsersGridScreen() { navController.navigate("user_details/$it") }
                    }

                    // User details
                    composable(
                        route = "user_details/{userEmail}",
                        arguments = listOf(navArgument("userEmail") { type = NavType.StringType })
                    ) { backStackEntry ->
                        ScreenPictureDetails(
                            userEmail = backStackEntry.arguments?.getString("userEmail") ?: ""
                        )
                    }

                }
            }
        }
    }
}
