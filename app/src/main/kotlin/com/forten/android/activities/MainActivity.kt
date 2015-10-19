package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import com.facebook.rebound.Spring
import com.facebook.rebound.SpringConfig
import com.facebook.rebound.SpringSystem
import com.forten.android.R
import com.forten.android.networks.models.Post
import com.forten.android.views.TimelineView
import java.util.*

class MainActivity : Activity() {
    private val SPRING_TENSION = 150.0
    private val SPRING_FRICTION = 18.0

    private lateinit var springSystem: SpringSystem
    private lateinit var springConfig: SpringConfig
    private lateinit var spring: Spring

    private lateinit var timeline: TimelineView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        springSystem = SpringSystem.create()
        springConfig = SpringConfig(SPRING_TENSION, SPRING_FRICTION)
        spring = springSystem.createSpring()
        spring.setSpringConfig(springConfig)

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