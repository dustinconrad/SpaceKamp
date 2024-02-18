package com.dustinconrad.spacekamp.di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun settingsPlatformModule(): Module = module {
    single<Settings> { StorageSettings() }
}