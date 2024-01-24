package com.dustinconrad.spacekamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.preference.PreferenceManager
import com.russhwolf.settings.SharedPreferencesSettings

class MainActivity : ComponentActivity() {

    private val settings by lazy {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        SharedPreferencesSettings(sharedPrefs)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(settings)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val settings = SharedPreferencesSettings(PreferenceManager.getDefaultSharedPreferences(LocalContext.current))
    App(settings)
}