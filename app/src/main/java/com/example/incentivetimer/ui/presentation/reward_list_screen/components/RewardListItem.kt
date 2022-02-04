package com.example.incentivetimer.ui.presentation.reward_list_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.incentivetimer.data.Reward
import com.example.incentivetimer.ui.IconKey
import com.example.incentivetimer.ui.iconKeyToIcon
import com.example.incentivetimer.ui.stringToIconKey
import com.example.incentivetimer.ui.theme.IncentiveTimerTheme


@Composable
fun RewardListItem(
    reward: Reward,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = {

        },
//        backgroundColor = if(isSystemInDarkTheme()) cardDark else cardLight
        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = iconKeyToIcon(stringToIconKey(reward.iconKey)),
                contentDescription = "Reward icon",
                Modifier
                    .padding(8.dp)
                    .size(64.dp)
            )
            Column {
                Text(reward.title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth(),
//                    style = MaterialTheme.typography.h6,
                )
                Text(
                    "${reward.chancePercent}%",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth(),
//                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, name = "Dark Mode", uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, name = "Light Mode", uiMode = UI_MODE_NIGHT_NO)
fun RewardItemPreview() {
    IncentiveTimerTheme {
        Surface {
            RewardListItem(reward = Reward(iconKey = IconKey.STAR.name, title = "title", chancePercent = 69))
        }
    }
}