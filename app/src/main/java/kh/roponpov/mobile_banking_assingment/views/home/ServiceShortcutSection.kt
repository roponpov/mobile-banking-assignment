package kh.roponpov.mobile_banking_assingment.views.home

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assingment.R
import kh.roponpov.mobile_banking_assingment.models.ServiceShortcutModel

@Composable
fun ServiceShortcutSection() {
    val servicesShortcutFirstRow = arrayOf(
        ServiceShortcutModel(
            route = "/transfer",
            serviceName = "Transfer",
            serviceIcon = R.drawable.ic_transfer,
        ),
        ServiceShortcutModel(
            route = "/payment",
            serviceName = "Payment",
            serviceIcon = R.drawable.ic_payment,
        ),
        ServiceShortcutModel(
            route = "/withdraw",
            serviceName = "Withdraw",
            serviceIcon = R.drawable.ic_withdraw,
        ),
    )
    val servicesShortcutSecondRow = arrayOf(
        ServiceShortcutModel(
            route = "/scan_pay",
            serviceName = "Scan Pay",
            serviceIcon = R.drawable.ic_scan_pay,
        ),
        ServiceShortcutModel(
            route = "/top_up",
            serviceName = "Top Up",
            serviceIcon = R.drawable.ic_top_up,
        ),
        ServiceShortcutModel(
            route = "/loan",
            serviceName = "Loans",
            serviceIcon = R.drawable.ic_loan,
        ),
    )

    Box(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 5.dp),
    ) {
        Text(
            "Services",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
    }

    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        servicesShortcutFirstRow.forEach {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Image(
                            painter = painterResource(it.serviceIcon),
                            contentDescription = it.serviceName
                        )
                        Text(
                            text = it.serviceName,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    }

    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        servicesShortcutSecondRow.forEach {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Image(
                            painter = painterResource(it.serviceIcon),
                            contentDescription = it.serviceName
                        )
                        Text(
                            text = it.serviceName,
                            style = MaterialTheme.typography.labelLarge
                        )
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
fun HomeScreenPreviewe() {
    HomeScreen()
}