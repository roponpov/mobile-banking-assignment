package kh.roponpov.mobile_banking_assingment.models

import kh.roponpov.mobile_banking_assingment.R
import kh.roponpov.mobile_banking_assingment.core.enums.BankCardType

enum class AccountType(val text: String) {
    SAVINGS("Saving Account"),
    JOINT("Join Account"),
    BUSINESS("Business Account");
}

class BankCardModel(
    val accountType: AccountType,
    val accountIcon: Int? = R.drawable.ic_bank,
    var accountNumber: String,
    var accountBalance: Double,
    var bankCardType: BankCardType
)