package com.example.incentivetimer.ui.presentation.reward_list_screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.incentivetimer.R
import com.example.incentivetimer.core.fabPadding
import com.example.incentivetimer.core.listBottomPadding
import com.example.incentivetimer.data.Reward
import com.example.incentivetimer.ui.IconKey
import com.example.incentivetimer.ui.presentation.reward_list_screen.components.RewardListItem
import com.example.incentivetimer.ui.theme.IncentiveTimerTheme
import com.example.incentivetimer.ui.theme.dark
import com.example.incentivetimer.ui.theme.light
import kotlinx.coroutines.launch

@Composable
fun RewardListScreen(viewModel: RewardListViewModel = hiltViewModel()) {
    val lazyListState = rememberLazyListState()
    val dummyRewards by viewModel.rewards.observeAsState(initial = emptyList())

    ScreenContent(lazyListState = lazyListState, dummyRewards = dummyRewards)
}

@Composable
fun ScreenContent(lazyListState: LazyListState, dummyRewards: List<Reward>) {
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Reward List") },
                backgroundColor = if (isSystemInDarkTheme()) Color(0xFF023047) else Color(0xFF219ebc)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(bottom = fabPadding),
                backgroundColor = if (isSystemInDarkTheme()) dark else light
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(
                        R.string.add_new_reward
                    )
                )
            }
        },
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LazyColumn(
                state = lazyListState,
                contentPadding = PaddingValues(
                    bottom = listBottomPadding,
                    top = 4.dp,
                    start = 2.dp,
                    end = 2.dp
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                items(dummyRewards) { reward ->
                    RewardListItem(reward = reward)
                }
            }
            AnimatedVisibility(
                visible = lazyListState.firstVisibleItemIndex > 4,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 68.dp),
            ) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            lazyListState.animateScrollToItem(1, 1)
                        }
                    },
                    backgroundColor = Color.Gray
                )
                {
                    Icon(
                        imageVector = Icons.Default.ExpandLess,
                        contentDescription = stringResource(R.string.scroll_to_top),
                        modifier = Modifier.align(Alignment.Center),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview("RewardListScreen", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview("RewardListScreen", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewRewardListScreen() {
    IncentiveTimerTheme() {
        Surface {
            ScreenContent(
                rememberLazyListState(), listOf(
                    Reward(iconKey = IconKey.SMARTPHONE.name, title = "title", chancePercent = 69),
                    Reward(iconKey = IconKey.TV.name, title = "title", chancePercent = 69),
                    Reward(iconKey = IconKey.CAKE.name, title = "title", chancePercent = 69),
                    Reward(iconKey = IconKey.SMARTPHONE.name, title = "title", chancePercent = 69),
                    Reward(iconKey = IconKey.TV.name, title = "title", chancePercent = 69),
                    Reward(iconKey = IconKey.CAKE.name, title = "title", chancePercent = 69),
                    Reward(iconKey = IconKey.SMARTPHONE.name, title = "title", chancePercent = 69),
                    Reward(iconKey = IconKey.CAKE.name, title = "title", chancePercent = 69),
                )
            )
        }
    }
}
