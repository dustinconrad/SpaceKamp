package com.dustinconrad.spacekamp

import androidx.compose.ui.window.ComposeUIViewController
import com.russhwolf.settings.NSUserDefaultsSettings
import platform.Foundation.NSUserDefaults

fun MainViewController() = ComposeUIViewController {
    val settings by lazy {
        NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
    }
    App(settings)
}
