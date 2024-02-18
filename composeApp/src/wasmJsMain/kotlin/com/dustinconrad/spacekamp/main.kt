package com.dustinconrad.spacekamp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.dustinconrad.spacekamp.di.appModule
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(appModule())
    }
    CanvasBasedWindow(canvasElementId = "ComposeTarget") { App() }
}