package com.dustinconrad.spacekamp.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dustinconrad.spacekamp.login.Token
import com.dustinconrad.spacekamp.login.TokenRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScene(
    onLoginToken: (Token?) -> Unit = {},
    tokenRepo: TokenRepository = koinInject()
) {
    Column(Modifier.fillMaxWidth(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center) {
        Image(painterResource("compose-multiplatform.xml"), null)
    }
    LaunchedEffect(key1 = null) {
        val tokenResult: List<Token?> = awaitAll(
                async { tokenRepo.get() },
                async { delay(500); null }
        )
        onLoginToken(tokenResult[0])
    }
}