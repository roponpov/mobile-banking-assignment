package kh.roponpov.mobile_banking_assingment.views.card

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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assingment.R
import kh.roponpov.mobile_banking_assingment.models.ServiceShortcutModel
import java.text.DecimalFormat

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
                    // CHANGE THIS: 1.6f or 2f makes it a clean rectangle
                    // instead of a giant square.
                    .aspectRatio(1.6f)
                    .clip(RoundedCornerShape(16.dp)), // Adds rounded corners to your image
                painter = painterResource(R.drawable.banner_mobile_banking_card),
                contentDescription = "Banner",
                // SCALE: This ensures the image fills the rectangle without stretching
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
        }

        Text(
            "Services",
            modifier = Modifier.padding(start = 16.dp),
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
    }
}

@Composable
@Preview(
    showBackground = true
)
fun CardScreenPreview() {
    CardScreen()
}