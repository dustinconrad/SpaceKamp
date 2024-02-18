package com.dustinconrad.spacekamp.login

import co.touchlab.kermit.Logger
import co.touchlab.kermit.loggerConfigInit
import co.touchlab.kermit.platformLogWriter
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlin.jvm.JvmInline

@JvmInline
value class Token(val value: String)

const val TOKEN_KEY = "TOKEN"

class TokenRepository(
    private val settings: Settings,
    private val logger: Logger = Logger(loggerConfigInit(platformLogWriter()), "TknRpo")
) {

    fun save(token: Token) {
        logger.d { "Saving $token" }
        settings[TOKEN_KEY] = token.value
    }

    fun get(): Token? = settings.getStringOrNull(TOKEN_KEY)?.let { Token(it) }?.also { logger.d { "Fetched $it" } }

}