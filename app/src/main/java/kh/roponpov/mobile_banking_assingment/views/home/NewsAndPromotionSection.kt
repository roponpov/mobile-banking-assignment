package kh.roponpov.mobile_banking_assingment.views.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assingment.R

@Composable
fun NewsAndPromotionSection() {
    val banners = arrayOf(
        R.drawable.ropon_bank_banner_discount,
        R.drawable.ropon_banner_get_two_usd,
        R.drawable.ropon_banner_15_off,
    )
    val pagerState = rememberPagerState(pageCount = { banners.count() })

    Box(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 5.dp),
    ) {
        Text(
            "News & Promotions",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
    }
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        pageSpacing = 16.dp,
        modifier = Modifier.height(120.dp),
    ) { page ->
        val banner = banners[page]

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
            Column {
                Image(
                    painter = painterResource(banner),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(
            alignment = Alignment.CenterHorizontally,
            space = 2.dp,
        )
    ) {
        items(banners.count()) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape,
                    )
                    .background(
                        color = if (pagerState.currentPage == index)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onPrimary,
                        shape = CircleShape,
                    )
            )
        }
    }
}