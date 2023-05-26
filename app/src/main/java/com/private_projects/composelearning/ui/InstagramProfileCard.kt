package com.private_projects.composelearning.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.private_projects.composelearning.ui.theme.ComposeLearningTheme

@Composable
fun InstagramProfileCard() {
    Card(
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onBackground)
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ContentBox(icon = true)
                ContentBox(upperText = "6950", lowerText = "Posts")
                ContentBox(upperText = "436M", lowerText = "Followers")
                ContentBox(upperText = "76", lowerText = "Following")
            }
            Text(text = "Instagram", fontSize = 24.sp, fontFamily = FontFamily.Cursive)
            Text(text = "#YoursToMake", fontSize = 12.sp)
            Text(text = "www.facebook.com/emotional_health", fontSize = 12.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { }) {
                Text(text = "Follow")
            }
        }
    }
}

@Preview
@Composable
fun DarkInstagramPreview() {
    ComposeLearningTheme(darkTheme = true) {
        InstagramProfileCard()
    }
}

@Preview
@Composable
fun LightInstagramPreview() {
    ComposeLearningTheme(darkTheme = false) {
        InstagramProfileCard()
    }
}