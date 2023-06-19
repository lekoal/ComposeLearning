package com.private_projects.composelearning.ui

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VkMainScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    val snackbarHostState by remember {
        mutableStateOf(SnackbarHostState())
    }
    val scope = rememberCoroutineScope()
    var fabIsShown by remember {
        mutableStateOf(true)
    }
    Scaffold(
        bottomBar = {
            BottomNav()
        },
        floatingActionButton = {
            if (fabIsShown) {
                FloatingActionButton(onClick = {
                    scope.launch {
                        val resultSnackBar = snackbarHostState.showSnackbar(
                            message = "Look at my snack",
                            actionLabel = "Hide my FAB",
                            duration = SnackbarDuration.Long
                        )
                        if (resultSnackBar == SnackbarResult.ActionPerformed) {
                            fabIsShown = !fabIsShown
                        }
                    }
                }, shape = CircleShape) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        VkNewsClient(it, viewModel)
    }
}

@Composable
private fun BottomNav() {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Favorite,
        BottomNavigationItem.Profile
    )
    var selectedScreen by rememberSaveable {
        mutableStateOf(0)
    }
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        NavigationBar {
            items.forEachIndexed { index, bottomNavigationItem ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = bottomNavigationItem.icon,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = stringResource(id = bottomNavigationItem.labelId)) },
                    selected = index == selectedScreen,
                    onClick = { selectedScreen = index },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        indicatorColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Black

    @Composable
    override fun rippleAlpha() = RippleAlpha(
        0f,
        0f,
        0f,
        0f
    )
}