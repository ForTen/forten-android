package com.forten.android.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.forten.android.networks.models.Post
import com.forten.android.views.FeedItemView

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {
    val context: Context
    val feedList: List<Post>

    constructor(ctx: Context, list: List<Post>) {
        context = ctx
        feedList = list
    }

    override fun onBindViewHolder(holder: FeedViewHolder?, position: Int) {
        val feed = feedList.get(position)
        holder?.feedItemView?.updateFeed(feed)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedViewHolder? {
        val itemView = FeedItemView(context)
        return FeedViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return feedList.size()
    }

    class FeedViewHolder : RecyclerView.ViewHolder {
        val feedItemView: FeedItemView

        constructor(view: FeedItemView) : super(view) {
            feedItemView = view
        }
    }
}