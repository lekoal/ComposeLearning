package com.private_projects.composelearning.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.private_projects.composelearning.R

sealed class BottomNavigationItem(
    val labelId: Int,
    val icon: ImageVector
) {
    object Home : BottomNavigationItem(
        labelId = R.string.main_title,
        icon = Icons.Filled.Home
    )
    object Favorite : BottomNavigationItem(
        labelId = R.string.favorite_title,
        icon = Icons.Filled.Favorite
    )
    object Profile : BottomNavigationItem(
        labelId = R.string.profile_title,
        icon = Icons.Filled.Person
    )
}