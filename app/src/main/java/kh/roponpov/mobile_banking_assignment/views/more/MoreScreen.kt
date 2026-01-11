package kh.roponpov.mobile_banking_assignment.views.more

import android.content.res.Configuration
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.mobile_banking_assignment.R
import kh.roponpov.mobile_banking_assignment.models.SettingModel
import kh.roponpov.mobile_banking_assignment.views.home.HomeScreen
import org.w3c.dom.Text

@Composable
fun MoreScreen() {
    Scaffold (
        contentWindowInsets = WindowInsets(0)
    ){ paddingValue ->

        val settings = arrayOf(
            SettingModel(
                route = "/profile",
                label = "My Profile",
                icon = R.drawable.ic_my_profile,
                trailing = null,
            ),
            SettingModel(
                route = "/security",
                label = "Security",
                icon = R.drawable.ic_lock,
                trailing = null,
            ),
            SettingModel(
                route = "/language",
                label = "Language",
                icon = R.drawable.ic_language,
                trailing = {
                    Text(
                        "English",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimary.copy(
                                alpha = .6f
                            )
                        )
                    )
               },
            ),
            SettingModel(
                route = "/contact",
                label = "Contact Us",
                icon = R.drawable.ic_telephone,
                trailing = null,
            ),
            SettingModel(
                route = "/term",
                label = "Terms & Conditions",
                icon = R.drawable.ic_term_and_conditions,
                trailing = null,
            )
        )

        Column(modifier = Modifier.padding(paddingValue)) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp)
                        ) {
                            Box(
                                modifier = Modifier.matchParentSize()
                            ) {
                                Image(
                                    modifier = Modifier
                                        .matchParentSize()
                                        .blur(radius = 10.dp),
                                    painter = painterResource(R.drawable.profile),
                                    contentDescription = "Background",
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Column(
                                modifier = Modifier.matchParentSize(),
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .statusBarsPadding()
                                        .padding(start = 16.dp)
                                        .height(40.dp),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Text(
                                        "Settings",
                                        style = MaterialTheme.typography.titleLarge.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    )
                                }

                                Box(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .matchParentSize()
                                            .padding(bottom = 40.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(120.dp)
                                                .background(
                                                    shape = CircleShape,
                                                    color = MaterialTheme.colorScheme.primary,
                                                )
                                                .clip(shape = CircleShape)
                                                .border(
                                                    width = 5.dp,
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    shape = CircleShape,
                                                )
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.profile),
                                                contentDescription = "Profile",
                                                contentScale = ContentScale.Crop,
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "POV Ropon",
                                            style = MaterialTheme.typography.titleLarge.copy(
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onPrimary
                                            )
                                        )

                                        Text(
                                            "App ID: 449968",
                                            style = MaterialTheme.typography.titleSmall.copy(
                                                fontWeight = FontWeight.W600,
                                                color = MaterialTheme.colorScheme.onPrimary
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 350.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
                        )
                ){
                    LazyColumn (
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        items(settings){ setting ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = .2f)
                                ),
                            ) {
                                Row (
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                ){
                                    Icon(
                                        modifier = Modifier.size(25.dp),
                                        painter = painterResource(setting.icon),
                                        tint = MaterialTheme.colorScheme.onPrimary,
                                        contentDescription = ""
                                    )
                                    Text(
                                        setting.label,
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    )
                                    Spacer(modifier = Modifier.weight(1f))

                                    setting.trailing?.invoke()

                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        tint = MaterialTheme.colorScheme.onPrimary,
                                        contentDescription = "Arrow Forward"
                                    )
                                }
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(400.dp))
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
fun PreviewMoreScreen() {
    MoreScreen()
}