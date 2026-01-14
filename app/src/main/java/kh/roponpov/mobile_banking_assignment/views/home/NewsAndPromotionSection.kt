package kh.roponpov.mobile_banking_assignment.views.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assignment.R

@Composable
fun NewsAndPromotionSection() {
    val banners = remember {
        listOf(
            R.drawable.ropon_bank_banner_discount,
            R.drawable.ropon_banner_get_two_usd,
            R.drawable.ropon_banner_15_off,
        )
    }

    val pagerState = rememberPagerState(pageCount = { banners.size })

    Column {
        Text(
            text = "News & Promotions",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            // 🔹 Slider
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                pageSpacing = 16.dp,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                OutlinedCard(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.onPrimary),
                ) {
                    Image(
                        painter = painterResource(banners[page]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // 🔹 Indicator (ON TOP of slider)
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = .8f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                banners.forEachIndexed { index, _ ->
                    val selected = pagerState.currentPage == index

                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = if (selected)
                                    MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
                                else
                                    MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                    )
                }
            }
        }
    }
}
