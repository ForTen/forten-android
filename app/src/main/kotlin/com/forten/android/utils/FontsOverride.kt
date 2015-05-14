package com.forten.android.utils

import android.content.Context
import android.graphics.Typeface

/**
 * Created by mspark on 2015. 5. 14..
 */
public class FontsOverride {
    companion object {
        public fun setDefaultFont(context: Context, staticTypefaceFieldName: String, fontAssetName: String) {
            val regular = Typeface.createFromAsset(context.getAssets(), fontAssetName)
            replaceFont(staticTypefaceFieldName, regular)
        }

        protected fun replaceFont(staticTypefaceFieldName: String, newTypeface: Typeface) {
            val staticField = javaClass<Typeface>().getDeclaredField(staticTypefaceFieldName)
            staticField.setAccessible(true)
            staticField.set(null, newTypeface)
        }
    }
}