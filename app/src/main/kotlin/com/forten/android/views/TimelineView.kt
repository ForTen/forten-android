package com.forten.android.views

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.TextView
import com.forten.android.R
import com.forten.android.activities.PostActivity
import com.forten.android.networks.models.Post

class TimelineView : FrameLayout {

    val svTop: HorizontalScrollView

    val flBottom: FrameLayout
    val flMiddle: FrameLayout
    val flTop: FrameLayout

    val containers: Array<FrameLayout>

    val containerWidthCal: Array<Float> = arrayOf(1f, 0.6f, 0.3f)
    val textSizes: Array<Float> = arrayOf(32f, 24f, 16f)
    val alphas: Array<Float> = arrayOf(1f, 0.5f, 0.2f)

    val deviceWidth: Int
    val deviceHeight: Int
    val timelineWidth: Int
    val timelineHeight: Int

    @JvmOverloads
    constructor(context: Context,
                attrs: AttributeSet? = null,
                defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.view_timeline, this)

        val window = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = window.defaultDisplay

        deviceWidth = display.width
        deviceHeight = display.height
        timelineWidth = deviceWidth * 10
        timelineHeight = deviceHeight
                .minus(resources.getDimensionPixelSize(R.dimen.main_tab_bar_height))
                .minus(resources.getDimensionPixelSize(R.dimen.btn_large_height))
                .minus(resources.getDimensionPixelSize(R.dimen.margin_timeline) * 3)
                .minus(getStatusBarHeight())

        svTop = findViewById(R.id.sv_top) as HorizontalScrollView

        flBottom = findViewById(R.id.fl_bottom) as FrameLayout
        flMiddle = findViewById(R.id.fl_middle) as FrameLayout
        flTop = findViewById(R.id.fl_top) as FrameLayout

        containers = arrayOf(flTop, flMiddle, flBottom)

        initializeContainers()
        initializeScrollView()
    }

    private fun initializeContainers() {
        for ((index, container) in containers.withIndex()) {
            container.layoutParams = FrameLayout.LayoutParams(
                    (timelineWidth * containerWidthCal[index]).toInt(),
                    ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun initializeScrollView() {
        svTop.viewTreeObserver.addOnScrollChangedListener {
            val scrollX = svTop.scrollX
            val middleScroll = scrollX * containerWidthCal[1]
            val bottomScroll = scrollX * containerWidthCal[2]

            val lpMiddle = flMiddle.layoutParams as FrameLayout.LayoutParams
            val lpBottom = flBottom.layoutParams as FrameLayout.LayoutParams

            lpMiddle.leftMargin = -middleScroll.toInt()
            lpBottom.leftMargin = -bottomScroll.toInt()

            flMiddle.layoutParams = lpMiddle
            flBottom.layoutParams = lpBottom
        }
    }

    public fun updateTimeline(posts: List<Post>) {
        for (post in posts) {
            val rand = (Math.random() * 3).toInt()
            val tv = TextView(context)
            tv.alpha = alphas[rand]
            tv.text = post.body
            tv.textSize = textSizes[rand]
            tv.setSingleLine(true)
            tv.measure(deviceWidth, deviceHeight)
            tv.setOnClickListener { v ->
                val intent = Intent(context, PostActivity::class.java)
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity, tv, "body").toBundle())
            }

            val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            val leftMargin = (Math.random() * (timelineWidth * containerWidthCal[rand] - tv.measuredWidth)).toInt()
            val topMargin = (Math.random() * (timelineHeight - tv.measuredHeight)).toInt()
            lp.leftMargin = leftMargin
            lp.topMargin = topMargin
            tv.layoutParams = lp

            containers[rand].addView(tv)
        }
    }

    private fun getStatusBarHeight(): Int {
        var result = 0;
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }
}