package kh.roponpov.mobile_banking_assingment.utils

class AppUtil {
    companion object {
        fun getInitials(name: String): String {
            val words = name.trim().split(" ")
            return when {
                words.size >= 2 -> "${words[0].take(1)}${words[1].take(1)}".uppercase()
                words.size == 1 -> words[0].take(2).uppercase()
                else -> "??"
            }
        }
    }
}