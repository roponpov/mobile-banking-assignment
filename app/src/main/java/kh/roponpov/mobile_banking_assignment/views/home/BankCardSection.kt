package kh.roponpov.mobile_banking_assignment.views.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assignment.R
import kh.roponpov.mobile_banking_assignment.core.enums.BankCardType
import kh.roponpov.mobile_banking_assignment.models.AccountType
import kh.roponpov.mobile_banking_assignment.models.BankCardModel
import java.text.DecimalFormat

@Composable
fun BankCardSection() {
    val bankCards = arrayOf(
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
        BankCardModel(
            accountType = AccountType.BUSINESS,
            accountNumber = "2342-00023-13",
            accountBalance = 19990.00,
            bankCardType = BankCardType.SECONDARY,
        )
    )
    val pagerState = rememberPagerState(pageCount = { bankCards.count() })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(start = 16.dp, end = 32.dp),
        pageSpacing = 16.dp,
    ) { page ->
        var isShowSensitive by remember(page) { mutableStateOf(true) }
        val amountFormatter = remember { DecimalFormat("#,##0.00") }
        val card = bankCards[page]

        OutlinedCard(
            modifier = Modifier.fillMaxWidth(),
            // onClick = {},
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(card.accountType.text,
                            style = MaterialTheme.typography.labelLarge
                        )
                        Image(
                            modifier = Modifier
                                .size(18.dp)
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    isShowSensitive = !isShowSensitive
                                },
                            painter = painterResource(
                                if (isShowSensitive)
                                    R.drawable.ic_visibility_off
                                else
                                    R.drawable.ic_visibility
                            ),
                            contentDescription = "Eye"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .blur(
                                radius = if (isShowSensitive) 8.dp else 0.dp,
                                edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(5.dp))
                            ),
                    ) {
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

                    Box(
                        modifier = Modifier
                            .blur(
                                radius = if (isShowSensitive) 8.dp else 0.dp,
                                edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(5.dp))
                            ),
                    ) {
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