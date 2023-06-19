package com.private_projects.composelearning.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun MaterialComponents() {
    Test()
}

@Composable
private fun Test() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Example3()
    }
}

@Composable
private fun Example1() {
    OutlinedButton(onClick = { }, shape = RoundedCornerShape(8.dp)) {
        Text(text = "Hello World!")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Example2() {
    TextField(
        value = "Value",
        onValueChange = { },
        label = { Text(text = "Label") },
        singleLine = true
    )
}

@Composable
private fun Example3() {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = "Are you sure?") },
        text = { Text(text = "Do you want to delete this file?") },
        confirmButton = {
            TextButton(onClick = { }) {
                Text(text = "Yes")
            }
        },
        dismissButton = {
            TextButton(onClick = { }) {
                Text(text = "No")
            }
        },
        shape = RoundedCornerShape(8.dp)
    )
}