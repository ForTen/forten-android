package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import com.forten.android.R

/**
 * Created by mspark on 2015. 5. 7..
 */
public class LoginActivity : Activity() {

    private var ivSlogan: ImageView? = null
    private var ivLogo: ImageView? = null
    private var loInput: LinearLayout? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var btnLogin: Button? = null
    private var ivIngichuk: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        ivSlogan = findViewById(R.id.iv_slogan) as ImageView
        ivLogo = findViewById(R.id.iv_logo) as ImageView
        loInput = findViewById(R.id.lo_input) as LinearLayout
        etEmail = findViewById(R.id.et_email) as EditText
        etPassword = findViewById(R.id.et_password) as EditText
        btnLogin = findViewById(R.id.btn_login) as Button
        ivIngichuk = findViewById(R.id.iv_ingichuk) as ImageView

        Handler().postDelayed({ -> enter()}, 2500)
    }

    private fun enter() {
        var lp = ivLogo?.getLayoutParams() as RelativeLayout.LayoutParams

        lp.removeRule(RelativeLayout.CENTER_IN_PARENT)
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL)
        lp.addRule(RelativeLayout.ABOVE, R.id.lo_input)
        lp.bottomMargin = getResources().getDimensionPixelSize(R.dimen.margin_huge)

        ivLogo?.setLayoutParams(lp)

        ivSlogan?.setVisibility(View.INVISIBLE)
        loInput?.setVisibility(View.VISIBLE)
        ivIngichuk?.setVisibility(View.VISIBLE)
    }
}

