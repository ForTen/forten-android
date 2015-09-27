package com.forten.android.activities

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import com.forten.android.R
import com.forten.android.networks.ApiManager
import com.forten.android.networks.responses.UserResponse
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

public class LoginActivity : Activity() {

    private lateinit var ivSlogan: ImageView
    private lateinit var ivLogo: ImageView
    private lateinit var loInput: LinearLayout
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var ivIngichuk: ImageView

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

        initEvent()
    }

    private fun initEvent() {
        btnLogin.setOnClickListener { login() }
    }

    private fun login() {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        if (email.length() == 0 || password.length() == 0) {
            return
        }

        val service = ApiManager.getUserService()
        service.login(etEmail.text.toString(), etPassword.text.toString(), object : Callback<UserResponse> {
            override fun failure(error: RetrofitError?) {
                Toast.makeText(this@LoginActivity, error?.getMessage(), Toast.LENGTH_LONG).show()
            }

            override fun success(t: UserResponse?, response: Response?) {
                if (t?.success ?: false) {
                    Toast.makeText(this@LoginActivity, "Hi ${t?.user?.username}!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@LoginActivity, "Failed!", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun enter() {
        var lp = ivLogo.getLayoutParams() as RelativeLayout.LayoutParams

        lp.removeRule(RelativeLayout.CENTER_IN_PARENT)
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL)
        lp.addRule(RelativeLayout.ABOVE, R.id.lo_input)
        lp.bottomMargin = getResources().getDimensionPixelSize(R.dimen.margin_huge)

        ivLogo.setLayoutParams(lp)

        ivSlogan.setVisibility(View.INVISIBLE)
        loInput.setVisibility(View.VISIBLE)
        ivIngichuk.setVisibility(View.VISIBLE)
    }
}

