package com.example.rma_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rma_project.ui.screen.CityDetailScreen
import com.example.rma_project.ui.screen.CitySearchScreen
import com.example.rma_project.ui.screen.LoginScreen
import com.example.rma_project.ui.screen.RegisterScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login"){
                composable("login")
                {
                    LoginScreen(navController = navController)
                }
                composable("register")
                {
                    RegisterScreen(navController = navController)
                }
                composable("home")
                {
                    CitySearchScreen(navController = navController)
                }
                composable(
                    "city-detail/{cityName}/{cityCountry}/{cityPopulation}",
                    arguments = listOf(
                        navArgument("cityName") { type = NavType.StringType },
                        navArgument("cityCountry") { type = NavType.StringType },
                        navArgument("cityPopulation") { type = NavType.IntType },
                    )
                ) { backStackEntry ->
                    val cityName = backStackEntry.arguments?.getString("cityName")
                    val cityCountry = backStackEntry.arguments?.getString("cityCountry")
                    val cityPopulation = backStackEntry.arguments?.getInt("cityPopulation")
                    CityDetailScreen(navController,cityName, cityCountry, cityPopulation)
                }
            }
        }
    }
}
