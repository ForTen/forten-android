package com.forten.android.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.forten.android.R
import com.forten.android.networks.models.Post

class FeedItemView : RelativeLayout {

    var feed: Post? = null

    val tvMessage: TextView

    @JvmOverloads
    constructor(context: Context,
                attrs: AttributeSet? = null,
                defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.item_feed, this)

        tvMessage = findViewById(R.id.tv_message) as TextView
    }

    public fun updateFeed(feed: Post) {
        this.feed = feed
        tvMessage.text = feed.body
    }
}