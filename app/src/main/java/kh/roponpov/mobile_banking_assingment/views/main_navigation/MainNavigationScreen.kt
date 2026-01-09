package kh.roponpov.mobile_banking_assingment.views.main_navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kh.roponpov.mobile_banking_assingment.models.BottomNavigationItem
import kh.roponpov.mobile_banking_assingment.views.account.AccountScreen
import kh.roponpov.mobile_banking_assingment.views.card.CardScreen
import kh.roponpov.mobile_banking_assingment.views.home.HomeScreen
import kh.roponpov.mobile_banking_assingment.views.more.MoreScreen

@Composable
fun MainScreen(paddingValues: PaddingValues) {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Account,
        BottomNavigationItem.Card,
        BottomNavigationItem.More
    )

    Scaffold(
        bottomBar = {
            BottomBarSection(
                navController = navController,
                items = items
            )
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItem.Account.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(BottomNavigationItem.Home.route) {
                HomeScreen()
            }
            composable(BottomNavigationItem.Account.route) {
                AccountScreen()
            }
            composable(BottomNavigationItem.Card.route) {
                CardScreen()
            }
            composable(BottomNavigationItem.More.route) {
                MoreScreen()
            }
        }
    }
}
