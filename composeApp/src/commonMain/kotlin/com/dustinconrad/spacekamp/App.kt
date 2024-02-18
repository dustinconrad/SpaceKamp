package com.dustinconrad.spacekamp
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.dustinconrad.spacekamp.di.TokenModule
import com.dustinconrad.spacekamp.di.settingsPlatformModule
import com.dustinconrad.spacekamp.login.LoginScene
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = {
        modules(
            settingsPlatformModule(),
            TokenModule
        )
    }) {
        MaterialTheme {
            LoginScene()
        }
    }
}

fun todaysDate(): String {
    fun LocalDateTime.format() = toString().substringBefore('T')

    val now = Clock.System.now()
    val zone = TimeZone.currentSystemDefault()
    return now.toLocalDateTime(zone).format()
}