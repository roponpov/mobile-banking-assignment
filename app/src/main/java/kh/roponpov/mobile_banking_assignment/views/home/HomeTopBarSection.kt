package kh.roponpov.mobile_banking_assignment.views.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assignment.R

@Composable
fun HomeTopBarSection(scrollOffset: Float){
    // Collapse configuration
    val maxHeight = 50.dp
    val maxScroll = 120f

    val heightDp: Dp = (maxHeight.value - scrollOffset / 2).coerceIn(0f, maxHeight.value).dp
    val progress = (scrollOffset / maxScroll).coerceIn(0f, 1f)

    // Avatar size: 55dp -> 35dp
    val profileSize = (50f - (20f * progress)).coerceAtLeast(35f).dp

    // Text scale & fade
    val textScale = 1f - (0.2f * progress)
    val textAlpha = 1f - progress

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Column {
                Spacer(
                    modifier = Modifier
                        .height(heightDp),
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Box(
                        modifier = Modifier
                            .size(profileSize)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .clip(
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                        )
                    }

                    Column(
                        modifier = Modifier.graphicsLayer {
                            scaleX = textScale
                            scaleY = textScale
                            alpha = textAlpha
                            transformOrigin = TransformOrigin(0f, 0.5f)
                        }
                    ) {
                        Text(
                            text = "Morning, Ropon!",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "05 Jan 2026 12:00 AM",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }

            Box(modifier = Modifier.weight(1f)) {}

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = .2f),
                        shape = RoundedCornerShape(5.dp),
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.padding(5.dp),
                    painter = painterResource(R.drawable.ic_khqr),
                    contentDescription = "KHQR"
                )
            }

            Box(modifier = Modifier.width(2.dp))

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = .2f),
                        shape = RoundedCornerShape(5.dp),
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.padding(5.dp),
                    painter = painterResource(R.drawable.ic_notification),
                    contentDescription = "Notification"
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
fun HomeScreenPreviewwe() {
    HomeScreen()
}