package com.forten.android.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.forten.android.R

/**
 * Created by bbarm on 2015. 10. 16..
 */
class MainActionBar : LinearLayout {

    @JvmOverloads
    constructor(context: Context,
                attrs: AttributeSet? = null,
                defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        orientation = LinearLayout.HORIZONTAL
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )

        inflate()
    }

    private fun inflate() {
        LayoutInflater.from(context).inflate(R.layout.actionbar_main, this)
    }
}