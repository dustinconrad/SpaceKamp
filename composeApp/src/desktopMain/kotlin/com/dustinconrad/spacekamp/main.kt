package com.dustinconrad.spacekamp

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dustinconrad.spacekamp.di.appModule
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(appModule())
    }
    Window(onCloseRequest = ::exitApplication, title = "SpaceKamp") {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    startKoin {
        modules(appModule())
    }
    App()
}