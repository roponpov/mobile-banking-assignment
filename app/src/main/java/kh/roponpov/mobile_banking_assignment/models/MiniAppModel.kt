package kh.roponpov.mobile_banking_assignment.models

class MiniAppModel(
    val appChannel: String,
    val appIcon: Int,
    val appName: String,
    val isAvailable: Boolean = false
)