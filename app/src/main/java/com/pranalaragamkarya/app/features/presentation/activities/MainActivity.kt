package com.pranalaragamkarya.app.features.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.pranalaragamkarya.app.features.presentation.screens.HomeScreen
import com.pranalaragamkarya.app.features.presentation.screens.LandingScreen
import com.pranalaragamkarya.app.features.presentation.utils.ScreenRoute
import com.pranalaragamkarya.app.ui.theme.PranalaRagamKaryaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PranalaRagamKaryaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "onboarding"){
                        navigation(startDestination = ScreenRoute.Landing.route, "landing"){
                            composable(ScreenRoute.Landing.route){entry ->
                                // go to landing
                                LandingScreen(navController = navController)
                            }
                            composable(ScreenRoute.Home.route){entry ->
                                // go to home
                                HomeScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

