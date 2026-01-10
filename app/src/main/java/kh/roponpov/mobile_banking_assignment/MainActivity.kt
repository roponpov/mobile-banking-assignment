package kh.roponpov.mobile_banking_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import kh.roponpov.mobile_banking_assignment.core.themes.AppTheme
import kh.roponpov.mobile_banking_assignment.views.main_navigation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(
                    bottomBar = {},
                    modifier = Modifier.fillMaxSize()
                ) { MainScreen(it) }
            }
        }
    }
}