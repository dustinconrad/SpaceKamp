package com.dustinconrad.spacekamp

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.russhwolf.settings.PreferencesSettings
import java.util.prefs.Preferences

fun main() = application {
    val settings by lazy {
        val preferences = Preferences.userRoot()
        PreferencesSettings(preferences)
    }

    Window(onCloseRequest = ::exitApplication, title = "SpaceKamp") {
        App(settings)
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    val settings = PreferencesSettings(Preferences.userRoot())
    App(settings)
}