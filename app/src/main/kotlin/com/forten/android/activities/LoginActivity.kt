package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import com.forten.android.R

/**
 * Created by mspark on 2015. 5. 7..
 */
public class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
    }
}

