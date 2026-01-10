package kh.roponpov.mobile_banking_assignment.models

import kh.roponpov.mobile_banking_assignment.R

sealed class BottomNavigationItem(
    val route: String,
    val label: String,
    val icon: Int
) {
    data object Home : BottomNavigationItem("home", "Home", R.drawable.ic_home)
    data object Account : BottomNavigationItem("accounts", "Accounts", R.drawable.ic_account)
    data object Card : BottomNavigationItem("cards", "Cards", R.drawable.ic_card)
    data object More : BottomNavigationItem("more", "More", R.drawable.ic_more)
}
