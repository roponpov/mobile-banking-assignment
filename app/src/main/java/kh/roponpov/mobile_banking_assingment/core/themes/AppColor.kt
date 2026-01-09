package kh.roponpov.mobile_banking_assingment.core.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Brand Colors
val BankingNavy = Color(0xFF1B2531)
val BankingTeal = Color(0xFF2D6A61)
val BankingTealLight = Color(0xFFE8F2F0)

// Status Colors (Transactions)
val ExpenseRed = Color(0xFFE57373)
val IncomeGreen = Color(0xFF4CAF50)
val GoldWarning = Color(0xFFFFB300)

// Neutral Palette
val BackgroundLight = Color(0xFFF2F5F8)
val SurfaceWhite = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFF8E99A6)
val OutlineGrey = Color(0xFFE0E6ED)

// Credit Card Specific
val MasterRed = Color(0xFFEB001B)
val MasterOrange = Color(0xFFFF5F00)
val CardDarkGradient = Color(0xFF1A1D21)

val LightColorScheme = lightColorScheme(
    primary = BankingTeal,
    onPrimary = Color.White,
    primaryContainer = BankingTealLight,
    onPrimaryContainer = BankingTeal,

    secondary = BankingNavy,
    onSecondary = Color.White,

    background = BackgroundLight,
    onBackground = BankingNavy,

    surface = SurfaceWhite,
    onSurface = BankingNavy,

    surfaceVariant = Color.White,
    onSurfaceVariant = TextSecondary,

    error = ExpenseRed,
    onError = Color.White,

    outline = OutlineGrey
)

val DarkColorScheme = darkColorScheme(
    primary = BankingTeal,
    onPrimary = Color.White,
    background = Color(0xFF0F1720),
    surface = Color(0xFF1B2531),
    onSurface = Color.White
)