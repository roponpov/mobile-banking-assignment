package kh.roponpov.mobile_banking_assignment.views.home

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import kh.roponpov.mobile_banking_assignment.R
import kh.roponpov.mobile_banking_assignment.models.MiniAppModel
import kh.roponpov.mobile_banking_assignment.utils.AppUtil

@Composable
fun MiniAppsSection(){
    val miniApps = remember {
        listOf(
            MiniAppModel(
                appChannel = "kh.roponpov.smart_axiata",
                appIcon = R.drawable.ic_smart,
                appName = "Smart Axiata",
                isAvailable = true,
            ),
            MiniAppModel(
                appChannel = "kh.roponpov.metfone",
                appIcon = R.drawable.ic_metfone,
                appName = "Metfone Service",
                isAvailable = false,
            ),

            MiniAppModel(
                appChannel = "kh.roponpov.stock_trader",
                appIcon = R.drawable.ic_stock_trader,
                appName = "Stock Trader",
                isAvailable = true,
            ),

            MiniAppModel(
                appChannel = "kh.roponpov.random_chat",
                appIcon = R.drawable.ic_random_chat,
                appName = "Random Chat",
                isAvailable = true,
            ),

            MiniAppModel(
                appChannel = "kh.roponpov.psa_369",
                appIcon = R.drawable.ic_e_commerce,
                appName = "Psa 369",
                isAvailable = false,
            ),
        )
    }

    Text(
        "Mini Apps",
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        )
    )
    LazyRow(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(
            color = MaterialTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(16.dp)
        ),
        contentPadding = PaddingValues(start = 16.dp, top = 16.dp, bottom = 16.dp),
    ) {
        items(
            items = miniApps,
            key = { it.appName }
        ) { transaction ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(90.dp).padding(end = 16.dp)
            ) {
                OutlinedCard(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.size(60.dp),
                    border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f))
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (transaction.appIcon != 0) {
                            Image(
                                modifier = Modifier.fillMaxSize(),
                                painter = painterResource(transaction.appIcon),
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.primaryContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = AppUtil.getInitials(transaction.appName),
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = transaction.appName,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground.copy(
                            alpha = .5f
                        ),
                        lineHeight =  1.2.em,
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
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
fun MiniAppsSectionPreview() {
    HomeScreen()
}