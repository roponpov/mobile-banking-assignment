package kh.roponpov.mobile_banking_assignment.core.extensions

import kh.roponpov.mobile_banking_assignment.core.enums.AppCurrency
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.abs

fun Double.formatTransactionAmount(
    currency: AppCurrency
): String {
    val sign = if (this >= 0) "+" else "-"
    val amount = abs(this)

    val formattedAmount = when (currency) {
        AppCurrency.USD -> {
            NumberFormat.getNumberInstance(Locale.US).apply {
                maximumFractionDigits = 0
                minimumFractionDigits = 0
            }.format(amount)
        }

        AppCurrency.KHR -> {
            NumberFormat.getNumberInstance(Locale.US).apply {
                maximumFractionDigits = 0
                minimumFractionDigits = 0
            }.format(amount)
        }
    }

    val symbol = when (currency) {
        AppCurrency.USD -> "$"
        AppCurrency.KHR -> "៛"
    }

    return "$sign$formattedAmount $symbol"
}


