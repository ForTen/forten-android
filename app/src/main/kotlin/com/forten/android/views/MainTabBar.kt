package com.forten.android.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.forten.android.R

class MainTabBar : RelativeLayout {

    @JvmOverloads
    constructor(context: Context,
                attrs: AttributeSet? = null,
                defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.main_tab_bar_height)
        )

        inflate()
    }

    private fun inflate() {
        LayoutInflater.from(context).inflate(R.layout.tabbar_main, this)
    }
}