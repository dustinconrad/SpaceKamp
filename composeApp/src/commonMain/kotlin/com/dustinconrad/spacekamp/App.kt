package com.dustinconrad.spacekamp
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

import com.dustinconrad.spacekamp.login.LoginScene
import com.dustinconrad.spacekamp.splash.SplashScene
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinContext

@Composable
fun App() {
    PreComposeApp {
        KoinContext {
            val navigator = rememberNavigator()
            MaterialTheme {
                NavHost(
                    navigator = navigator,
                    initialRoute = "/splash"
                ) {
                    scene("/splash") {
                        SplashScene({
                            if (it != null) {
                                navigator.navigate("/home")
                            } else {
                                navigator.navigate("/login")
                            }
                        })
                    }
                    scene("/login") {
                        LoginScene()
                    }
                    scene("/home") {

                    }
                }

            }
        }
    }
}

fun todaysDate(): String {
    fun LocalDateTime.format() = toString().substringBefore('T')

    val now = Clock.System.now()
    val zone = TimeZone.currentSystemDefault()
    return now.toLocalDateTime(zone).format()
}