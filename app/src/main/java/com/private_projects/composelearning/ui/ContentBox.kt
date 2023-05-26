package com.private_projects.composelearning.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.private_projects.composelearning.R

@Composable
fun ContentBox(
    icon: Boolean = false,
    upperText: String? = null,
    lowerText: String? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        if (icon) {
            Image(
                painter = painterResource(id = R.drawable.instagram_1_svgrepo_com),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color.White)
            )
        } else {
            Text(
                text = upperText.toString(),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp,
                fontFamily = FontFamily.Cursive
            )
            Text(
                text = lowerText.toString(),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}