package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import com.forten.android.R
import com.forten.android.networks.models.Post
import com.forten.android.views.TimelineView
import java.util.*

class MainActivity : Activity() {

    private lateinit var timeline: TimelineView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeline = findViewById(R.id.timeline) as TimelineView

        val posts = ArrayList<Post>()
        for (i in 0..69) {
            val post = Post()
            post.body = "나랏말싸미듕긕에달아"
            posts.add(post)
        }

        timeline.updateTimeline(posts)
    }
}