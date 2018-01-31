package com.pedromassango.appintro

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Pedro Massango on 1/27/18.
 */
class TestIntroActivity : IntroActivity() {

    override fun setupIntro() {

        // Adding slides to show
        addSlide(IntroSlide(getString(R.string.app_name).toUpperCase(),
                getString(R.string.descp),
                backgroundColor = Color.MAGENTA,
                mIcon = R.mipmap.ic_launcher))
        addSlide(IntroSlide(getString(R.string.app_name),
                getString(R.string.descp),
                backgroundColor = Color.BLUE,
                mIcon = R.mipmap.ic_launcher))

        addSlide(IntroSlide(getString(R.string.app_name),
                getString(R.string.descp),
                backgroundColor = Color.BLACK,
                mIcon = R.mipmap.ic_launcher))
        addSlide(IntroSlide(getString(R.string.app_name),
                getString(R.string.descp),
                backgroundColor = Color.RED,
                mIcon = R.mipmap.ic_launcher))
    }

    override fun onBack(slide: IntroSlide) {
        // Back pressed
    }

    override fun onNext(slide: IntroSlide) {
        // Next pressed
    }

    override fun onFinish(slide: IntroSlide) {
        // All slides was shown.
        finish()
    }
}