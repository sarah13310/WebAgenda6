package com.xenatronics.webagenda.presentation.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.xenatronics.webagenda.presentation.components.ListTaskBar

@Composable
fun LoadingScreen( title: String = "") {
    Scaffold(
        topBar = {
            ListTaskBar(title = title, NavigateToListScreen = {
                //navController.popBackStack()
            })
        },
        content = {
            LoadingIndicator()
        }
    )
}

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

