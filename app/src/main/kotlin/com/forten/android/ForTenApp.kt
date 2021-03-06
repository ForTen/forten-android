package com.forten.android

import android.app.Application
import com.forten.android.utils.FontsOverride

public class ForTenApp : Application() {
    override fun onCreate() {
        super.onCreate()

        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Montserrat-Regular.ttf")
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Montserrat-Regular.ttf")
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Montserrat-Regular.ttf")
        FontsOverride.setDefaultFont(this, "DEFAULT_BOLD", "fonts/Montserrat-Bold.ttf")
    }
}
