package com.dustinconrad.spacekamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.dustinconrad.spacekamp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(appModule())
        }

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val context = LocalContext.current
    KoinApplication(application = {
        androidContext(context)
        modules(appModule())
    }) {
        //    val settings = SharedPreferencesSettings(PreferenceManager.getDefaultSharedPreferences(LocalContext.current))
        App()
    }
}