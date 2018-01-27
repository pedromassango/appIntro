package com.pedromassango.appintro

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Pedro Massango on 1/27/18.
 */
class TestIntroActivity: IntroActivity() {

    override fun setupIntro() {

        // Adding slides to show
        addSlide(IntroSlide(getString(R.string.app_name).toUpperCase(), getString(R.string.descp), R.mipmap.ic_launcher))
        addSlide(IntroSlide(getString(R.string.app_name), getString(R.string.descp), R.mipmap.ic_launcher))
        addSlide(IntroSlide(getString(R.string.app_name), getString(R.string.descp), R.mipmap.ic_launcher))
        addSlide(IntroSlide(getString(R.string.app_name).toUpperCase(), getString(R.string.descp), R.mipmap.ic_launcher))
    }

    override fun onBack(slideIndex: Int) {
        Toast.makeText(this, "BACK", Toast.LENGTH_SHORT).show()
    }

    override fun onNext(slideIndex: Int) {
        Toast.makeText(this, "NEXT", Toast.LENGTH_SHORT).show()
    }

    override fun onFinish(slideIndex: Int) {
        Toast.makeText(this, "FINISHED", Toast.LENGTH_SHORT).show()
    }
}