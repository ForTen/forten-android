package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.forten.android.R
import com.forten.android.adapters.FeedAdapter
import com.forten.android.networks.models.Post
import com.forten.android.views.MainActionBar
import java.util.*

class MainActivity : Activity() {

    private lateinit var rvTimeline: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar.customView = MainActionBar(this)
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.setDisplayShowCustomEnabled(true)

        rvTimeline = findViewById(R.id.rv_timeline) as RecyclerView

        initializeRecyclerView()
        loadData()
    }

    private fun initializeRecyclerView() {
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL

        rvTimeline.setHasFixedSize(false)
        rvTimeline.layoutManager = llm
    }

    private fun loadData() {
        val list = ArrayList<Post>()
        val feed = Post()
        feed.body = "이것은테스트데이터다"
        list.add(feed)
        val feed2 = Post()
        feed2.body = "Lorem ipsum dolor sit amet"
        list.add(feed2)
        val adapter = FeedAdapter(this, list)
        rvTimeline.adapter = adapter
    }
}