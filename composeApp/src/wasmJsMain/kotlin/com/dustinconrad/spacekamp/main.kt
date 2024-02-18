package com.dustinconrad.spacekamp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.russhwolf.settings.StorageSettings

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") { App() }
}