package com.dustinconrad.spacekamp

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.russhwolf.settings.PreferencesSettings
import java.util.prefs.Preferences

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "SpaceKamp") {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}