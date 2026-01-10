import kh.roponpov.mobile_banking_assignment.R

class TransactionModel(
    var transactionName: String,
    var accountName: String,
    var accountNumber: String,
    var amount: Double,
    var currency: String,
    var image: Int? = null,
    var createdDate: String,
) {
    companion object {
        val transactions = listOf(
            TransactionModel(
                "Transfer to",
                "POV ROPON",
                "001 552 342",
                -25.0,
                "USD",
                R.drawable.profile,
                "Today, 10:30 AM"
            ),
            TransactionModel(
                "Receive from",
                "PHANNA",
                "096 442 112",
                150.0,
                "USD",
                null,
                "Today, 08:15 AM"
            ),
            TransactionModel(
                "KHQR Payment",
                "Brown Coffee",
                "998 221 004",
                -4.5,
                "USD",
                R.drawable.ic_brown_coffee,
                "Yesterday, 04:20 PM"
            ),
            TransactionModel(
                "Transfer to",
                "Smart",
                "085 221 990",
                -15.0,
                "USD",
                R.drawable.ic_smart,
                "24 Oct 2025"
            ),
            TransactionModel(
                "KHQR Payment",
                "Zando BKK1",
                "445 112 003",
                -35.0,
                "USD",
                R.drawable.ic_zando,
                "23 Oct 2025"
            ),
            TransactionModel(
                "Utility Bill",
                "EDC",
                "990 112 334",
                -245000.0,
                "KHR",
                R.drawable.ic_edc,
                "22 Oct 2025"
            ),
            TransactionModel(
                "KHQR Payment",
                "Chip Mong 271",
                "776 554 112",
                -22.75,
                "USD",
                R.drawable.ic_chip_mong_271,
                "21 Oct 2025"
            ),
            TransactionModel(
                "Transfer to",
                "ROTHANA",
                "012 887 223",
                -50.0,
                "USD",
                null,
                "21 Oct 2025"
            ),
            TransactionModel(
                "Receive from",
                "KOSAL",
                "077 443 221",
                10.0,
                "USD",
                null,
                "20 Oct 2025"
            ),
            TransactionModel(
                "Merchant Pay",
                "Nham24",
                "112 009 887",
                -8.5,
                "USD",
                R.drawable.ic_nham_24,
                "19 Oct 2025"
            ),
            TransactionModel(
                "Merchant Pay",
                "Food Panda",
                "223 445 667",
                -5.25,
                "USD",
                R.drawable.ic_food_panda,
                "19 Oct 2025"
            ),
            TransactionModel(
                "Utility Bill",
                "PPWSA Water",
                "665 443 221",
                -18500.0,
                "KHR",
                R.drawable.ic_ppwsa_water,
                "18 Oct 2025"
            )
        )
    }
}