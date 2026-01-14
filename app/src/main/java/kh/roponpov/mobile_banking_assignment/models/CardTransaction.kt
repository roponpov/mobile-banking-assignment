package kh.roponpov.mobile_banking_assignment.models

import TransactionModel

class CardTransaction(
    val cardNumber: String,
    val transactions: ArrayList<TransactionModel>
)