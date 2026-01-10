package kh.roponpov.mobile_banking_assignment.views.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assignment.R
import kh.roponpov.mobile_banking_assignment.models.ServiceShortcutModel
import kh.roponpov.mobile_banking_assignment.utils.AppUtil

@Composable
fun CardScreen() {
    Column {
        val services = arrayOf(
            ServiceShortcutModel(
                route = "/transfer",
                serviceName = "Transfer",
                serviceIcon = R.drawable.ic_transfer,
            ),
            ServiceShortcutModel(
                route = "/pay_bills",
                serviceName = "Pay Bills",
                serviceIcon = R.drawable.ic_payment,
            ),
            ServiceShortcutModel(
                route = "/setting",
                serviceName = "Setting",
                serviceIcon = R.drawable.ic_setting,
            )
        )
        val pagerState = rememberPagerState(pageCount = { services.count() })

        HorizontalPager(
            state = pagerState,
            // 16dp on start lets the card align with the text
            // 32dp on end lets the user see a "peek" of the next image
            contentPadding = PaddingValues(start = 16.dp, end = 32.dp),
            pageSpacing = 16.dp,
        ) { _ ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.6f)
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(R.drawable.banner_mobile_banking_card),
                contentDescription = "Banner",
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
        }

        Text(
            "Services",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            services.forEach { service ->
                OutlinedCard(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = .2f)
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(
                            space = 10.dp,
                            alignment = Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(service.serviceIcon),
                            contentDescription = ""
                        )
                        Text(
                            service.serviceName,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }

        Text(
            "Transaction",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        LazyColumn (
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(TransactionModel.transactions) { transaction ->
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = .2f)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        if (transaction.image != 0 && transaction.image != null) {
                            Image(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape),
                                painter = painterResource(transaction.image!!),
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = AppUtil.getInitials(transaction.accountName),
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                )
                            }
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = 5.dp,
                                alignment = Alignment.CenterVertically
                            ),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                transaction.transactionName,
                                style = MaterialTheme.typography.labelLarge
                            )
                            Text(
                                transaction.createdDate,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            transaction.amount.toString(),
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = if (transaction.amount > 0.0)
                                    MaterialTheme.colorScheme.primary
                                        else
                                    MaterialTheme.colorScheme.error,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true
)
fun CardScreenPreview() {
    CardScreen()
}