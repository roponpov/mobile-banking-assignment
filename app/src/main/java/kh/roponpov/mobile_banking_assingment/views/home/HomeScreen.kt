package kh.roponpov.mobile_banking_assingment.views.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen() {
    // 1. Remember the LazyListState
    val listState = rememberLazyListState()

    // 2. Track scroll offset
    var scrollOffset by remember { mutableStateOf(0f) }

    // 3. Collect scroll changes
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collectLatest { (index, offset) ->
                // This is your scroll value
                scrollOffset = index * 100f + offset // approximate pixel scroll
            }
    }

    Scaffold(
        topBar = { HomeTopBarSection(scrollOffset = scrollOffset) }
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddingValues,
        ) {
            item { BankCardSection() }
            item { ServiceShortcutSection() }
            item { RecentSection() }
            item { NewsAndPromotionSection() }
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