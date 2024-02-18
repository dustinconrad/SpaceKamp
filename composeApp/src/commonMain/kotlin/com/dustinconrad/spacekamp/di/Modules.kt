package com.dustinconrad.spacekamp.di

import com.dustinconrad.spacekamp.login.TokenRepository
import org.koin.core.module.Module
import org.koin.dsl.module

expect fun settingsPlatformModule(): Module

val TokenModule = module {
    single { TokenRepository(get()) }
}