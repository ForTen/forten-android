package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.forten.android.R

class PostActivity : Activity() {

    private lateinit var tvBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        tvBody = findViewById(R.id.tv_body) as TextView
        tvBody.text = "나랏말싸미듕긕에달아"
        tvBody.textSize = 32f
    }
}