package kh.roponpov.mobile_banking_assignment.models

import androidx.compose.runtime.Composable

class SettingModel(
    val route: String,
    val icon: Int,
    val label: String,
    val trailing: (@Composable (() -> Unit))? = null
)