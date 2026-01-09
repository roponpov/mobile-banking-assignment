package kh.roponpov.mobile_banking_assingment.models

import kh.roponpov.mobile_banking_assingment.core.enums.BankCardType

class BankCardModel(
    var accountNumber: String,
    var accountBalance: Double,
    var bankCardType: BankCardType
)