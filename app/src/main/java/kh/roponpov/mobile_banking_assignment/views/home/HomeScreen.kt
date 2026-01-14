package kh.roponpov.mobile_banking_assignment.views.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen() {
    val listState = rememberLazyListState()
    var scrollOffset by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collectLatest { (index, offset) ->
                scrollOffset = index * 100f + offset
            }
    }

    Scaffold(
        topBar = { HomeTopBarSection(scrollOffset = scrollOffset) }
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = paddingValues,
        ) {
            item { BankCardSection() }
            item { ServiceShortcutSection() }
            item { RecentSection() }
            item { NewsAndPromotionSection() }
            item { MiniAppsSection() }
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
    HomeScreen()
}