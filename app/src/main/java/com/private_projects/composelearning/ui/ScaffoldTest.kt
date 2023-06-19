package com.private_projects.composelearning.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun ScaffoldTest() {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                repeat(3) {
                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = "Item $it") },
                        selected = false,
                        onClick = { })
                }
            }
        },
        drawerState = DrawerState(initialValue = DrawerValue.Closed),
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    ) {
        Scaffold(
            topBar = {
                TopBar()
            },
            bottomBar = {
                BottomBar()
            }
        ) {
            Text(text = "Some Text", modifier = Modifier.padding(it))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Current Bar",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            }
        }
    )
}

@Composable
private fun BottomBar() {
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Filled.Home, contentDescription = null)
            },
            label = {
                Text(text = "Home")
            },
            selected = true,
            onClick = { })
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Filled.Image, contentDescription = null)
            },
            label = {
                Text(text = "Images")
            },
            selected = false,
            onClick = { },
            alwaysShowLabel = false
        )
    }
}