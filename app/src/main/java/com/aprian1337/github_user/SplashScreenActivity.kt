package com.aprian1337.github_user

import android.R.id.home
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity() {
    private var splashScreenTime:Long= 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            var mainActivityIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish()
        }, splashScreenTime)
    }
}