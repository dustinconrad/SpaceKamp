package com.dustinconrad.spacekamp.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

@Composable
fun LoginScene(
    onLogin: () -> Unit = {},
    t: TokenRepository = koinInject()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Login")
                },
            )
        },
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = "",
                onValueChange = { },
                label = { Text("Token") }
            )
            Button(onClick = onLogin) {
                Text("Login")
            }
        }
    }
}