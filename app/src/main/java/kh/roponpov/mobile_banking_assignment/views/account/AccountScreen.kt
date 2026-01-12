package kh.roponpov.mobile_banking_assignment.views.account

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assignment.R
import kh.roponpov.mobile_banking_assignment.core.enums.BankCardType
import kh.roponpov.mobile_banking_assignment.models.AccountType
import kh.roponpov.mobile_banking_assignment.models.BankCardModel
import java.text.DecimalFormat

@Composable
fun AccountScreen() {
    val amountFormatter = remember { DecimalFormat("#,##0.00") }
    val bankCards = arrayOf(
        BankCardModel(
            accountType = AccountType.BUSINESS,
            accountNumber = "2342-00023-13",
            accountBalance = 19990.00,
            bankCardType = BankCardType.SECONDARY,
        ),
        BankCardModel(
            accountType = AccountType.JOINT,
            accountNumber = "1234-5678-11",
            accountBalance = 2749.00,
            bankCardType = BankCardType.PRIMARY,
        ),
        BankCardModel(
            accountType = AccountType.SAVINGS,
            accountNumber = "3433-29032-12",
            accountIcon = R.drawable.ic_saving,
            accountBalance = 50.00,
            bankCardType = BankCardType.SECONDARY,
        ),
    )

    LazyColumn(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                "Summary",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }

        item {
            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = .2f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        "Last update: Today 10:00 Am",
                        style = MaterialTheme.typography.bodySmall,
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Box(
                            modifier = Modifier.size(
                                width = 140.dp,
                                height = 100.dp
                            )
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(0.5f)
                                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                                    .background(Color(0xFF3D635E))
                                    .align(Alignment.BottomStart)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight(0.75f)
                                    .fillMaxWidth(0.5f)
                                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                                    .background(Color(0xFFD67B71))
                                    .border(
                                        2.dp,
                                        Color(0xFFC26D64),
                                        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                                    )
                                    .align(Alignment.BottomCenter)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight(0.5f)
                                    .fillMaxWidth(0.5f)
                                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                                    .background(Color(0xFFE9C46A))
                                    .border(
                                        2.dp,
                                        Color(0xFFD4A017),
                                        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                                    )
                                    .align(Alignment.BottomEnd)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                "Total Available Balance",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontWeight = FontWeight.Normal,
                                )
                            )
                            Text(
                                "\$2,799.00",
                                style = MaterialTheme.typography.headlineLarge.copy(
                                    fontWeight = FontWeight.ExtraBold,
                                )
                            )
                        }
                    }
                }
            }
        }

        item {
            Text(
                "All Accounts",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }

        items(bankCards) { card ->
            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = .2f)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            card.accountType.text,
                            style = MaterialTheme.typography.labelLarge
                        )

                        Box {
                            Text(
                                card.accountNumber,
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontWeight = FontWeight.Normal,
                                )
                            )
                        }

                        Box(modifier = Modifier.height(20.dp))

                        Box(
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(5.dp),
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = .1f),
                                )
                                .padding(horizontal = 5.dp, vertical = 2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                card.bankCardType.text,
                                style = MaterialTheme.typography.labelLarge.copy(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.W600
                                )
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(card.accountIcon!!),
                            contentDescription = "Bank"
                        )

                        Text(
                            "Available Balance",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Normal,
                            )
                        )

                        Box {
                            Text(
                                text = "$${amountFormatter.format(card.accountBalance)}",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.ExtraBold,
                                )
                            )
                        }
                    }
                }
            }
        }

    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "Light Mode"
)
fun HomeScreenPreview() {
    AccountScreen()
}