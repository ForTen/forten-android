package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.View
import android.widget.Button
import com.facebook.rebound.SimpleSpringListener
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
    private lateinit var btnAddPost: Button
    private lateinit var cvAddPost: CardView
    private lateinit var blanket: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        springSystem = SpringSystem.create()
        springConfig = SpringConfig(SPRING_TENSION, SPRING_FRICTION)
        spring = springSystem.createSpring()
        spring.setSpringConfig(springConfig)

        timeline = findViewById(R.id.timeline) as TimelineView
        btnAddPost = findViewById(R.id.btn_add_post) as Button
        cvAddPost = findViewById(R.id.cv_add_post) as CardView
        blanket = findViewById(R.id.blanket)

        val posts = ArrayList<Post>()
        for (i in 0..69) {
            val post = Post()
            post.body = "나랏말싸미듕긕에달아"
            posts.add(post)
        }

        timeline.updateTimeline(posts)

        initEvent()
    }

    private fun initEvent() {
        btnAddPost.setOnClickListener { openAddPostCard() }
        blanket.setOnClickListener { hideAddPostCard() }
    }

    private fun openAddPostCard() {
        cvAddPost.visibility = View.VISIBLE
        blanket.visibility = View.VISIBLE

        spring.removeAllListeners()
        spring.addListener(object : SimpleSpringListener() {
            override fun onSpringUpdate(spring: Spring?) {
                val value = spring?.currentValue
                cvAddPost.translationY = value!!.toFloat()
            }
        })

        val displayHeight = windowManager.defaultDisplay.height
        val cardHeight = cvAddPost.layoutParams.height
        val targetY = (displayHeight / 2) - (cardHeight / 2)

        spring.setCurrentValue(displayHeight.toDouble())
        spring.setEndValue(-targetY.toDouble())
    }

    private fun hideAddPostCard() {
        blanket.visibility = View.GONE

        spring.removeAllListeners()
        spring.addListener(object : SimpleSpringListener() {
            override fun onSpringUpdate(spring: Spring?) {
                val value = spring?.currentValue
                cvAddPost.translationY = value!!.toFloat()

                if (value == spring?.endValue) {
                    cvAddPost.visibility = View.GONE
                }
            }
        })

        val displayHeight = windowManager.defaultDisplay.height

        spring.setEndValue(displayHeight.toDouble())
    }

    override fun onBackPressed() {
        if (cvAddPost.isShown) {
            hideAddPostCard()
        } else {
            super.onBackPressed()
        }
    }
}