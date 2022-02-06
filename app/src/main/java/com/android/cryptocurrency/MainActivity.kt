package com.android.cryptocurrency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.android.cryptocurrency.ui.navigation.NavGraph
import com.android.cryptocurrency.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            CryptocurrencyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavGraph(navHostController = navHostController)
                }
            }
        }
    }
}