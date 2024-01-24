package com.dustinconrad.spacekamp
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.dustinconrad.spacekamp.login.LoginScene
import com.dustinconrad.spacekamp.login.TokenRepository
import com.russhwolf.settings.Settings
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun App(settings: Settings) {
    val tokenRepo = remember { TokenRepository(settings)  }
    MaterialTheme {
        LoginScene(tokenRepo)
    }
}

fun todaysDate(): String {
    fun LocalDateTime.format() = toString().substringBefore('T')

    val now = Clock.System.now()
    val zone = TimeZone.currentSystemDefault()
    return now.toLocalDateTime(zone).format()
}