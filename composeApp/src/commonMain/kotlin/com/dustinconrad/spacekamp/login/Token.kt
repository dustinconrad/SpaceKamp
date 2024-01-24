package com.dustinconrad.spacekamp.login

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlin.jvm.JvmInline

@JvmInline
value class Token(val value: String)

const val TOKEN_KEY = "TOKEN"

class TokenRepository(private val settings: Settings) {

    fun save(token: Token) {
        settings[TOKEN_KEY] = token.value
    }

    fun get(): Token? = settings.getStringOrNull(TOKEN_KEY)?.let { Token(it) }

}