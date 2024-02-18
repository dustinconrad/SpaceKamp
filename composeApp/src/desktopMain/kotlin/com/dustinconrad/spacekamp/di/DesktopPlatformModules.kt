package com.dustinconrad.spacekamp.di

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun settingsPlatformModule(): Module = module {
    single<Settings> {
        val preferences = Preferences.userRoot()
        PreferencesSettings(preferences)
    }
}