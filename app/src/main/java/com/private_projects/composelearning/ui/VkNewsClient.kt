package com.private_projects.composelearning.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.private_projects.composelearning.R
import com.private_projects.composelearning.domain.FeedPost
import com.private_projects.composelearning.domain.VkStatistics

@Composable
fun VkNewsClient(paddings: PaddingValues, viewModel: MainViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(enabled = true, state = ScrollState(0))
            .padding(paddings)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(width = 1.dp, color = Color.DarkGray),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                PostHeader()
                PostText()
                PostImage()
                PostStats(viewModel)
            }
        }
    }
}

@Composable
private fun PostHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.post_comunity_thumbnail),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape),
                    contentScale = ContentScale.Inside
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "text one",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = "time",
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }
        }
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun PostText() {
    Text(
        text = stringResource(R.string.content_text),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(vertical = 10.dp)
    )
}

@Composable
private fun PostImage() {
    Image(
        painter = painterResource(id = R.drawable.post_content_image),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun PostStats(viewModel: MainViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextIcon(VkStatistics.Views, viewModel)
            }
        }
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextIcon(VkStatistics.Exchanges, viewModel)
                Spacer(modifier = Modifier.width(15.dp))
                TextIcon(VkStatistics.Comments, viewModel)
                Spacer(modifier = Modifier.width(15.dp))
                TextIcon(VkStatistics.Favorites, viewModel)
            }
        }
    }
}

@Composable
private fun TextIcon(statusNumbers: VkStatistics, viewModel: MainViewModel) {
    val activeColor = MaterialTheme.colorScheme.onSecondary
    val modEndPadding = Modifier.padding(end = 10.dp)
    val feedPost = viewModel.feedPost.observeAsState(FeedPost())
    Text(
        text = getTextValue(
            statusNumbers = statusNumbers,
            feedPost = feedPost
        ).toString(),
        modifier = modEndPadding,
        color = activeColor
    )
    Icon(
        painter = painterResource(id = statusNumbers.iconId),
        contentDescription = null,
        tint = activeColor,
        modifier = Modifier.clickable {
            Log.d("LOGGING", "CLICK!")
            viewModel.updateCount(statusNumbers)
        }
    )
}

@Composable
private fun getTextValue(
    statusNumbers: VkStatistics,
    feedPost: State<FeedPost>
): Int {

    feedPost.value.statistics.forEach {
        if (it.iconId == statusNumbers.iconId) {
            Log.d("LOGGING", it.iconId.toString())
            return it.count
        }
    }
    return 0
}

