package com.pedromassango.appintro

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_intro.*

abstract class IntroActivity : AppCompatActivity(), SliderActionListener {

    private val slides = mutableListOf<IntroSlide>()
    private var currentSlideIndex = 0
    abstract fun setupIntro()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        this.setupIntro() // get added slides

        // set dots to zero
        addDotsIndicator(0)

        val adapter = SliderAdapter(slides)
        intro_view_pager_slider.adapter = adapter
        intro_view_pager_slider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {

                currentSlideIndex = position

                addDotsIndicator(position)

                when (position == 0) {
                    true -> btn_back.visibility = View.GONE
                    false -> {
                        btn_back.visibility = View.VISIBLE

                        btn_next.text = if (currentSlideIndex == slides.size - 1) "FINISH" else "NEXT"
                    }
                }
            }
        })

        btn_back.setOnClickListener {

            intro_view_pager_slider.setCurrentItem(
                    intro_view_pager_slider.currentItem - 1,
                    true)
            // Notify back pressed
            onBack(slides[currentSlideIndex])
        }

        btn_next.setOnClickListener {

            if (slides.size - 1 == currentSlideIndex) {

                // DONE CLICKED when no more slides
                onFinish(slides[currentSlideIndex])

            } else {
                intro_view_pager_slider.setCurrentItem(
                        intro_view_pager_slider.currentItem + 1,
                        true)

                // notify next btn click
                onNext(slides[currentSlideIndex])
            }
        }
    }

    private fun addDotsIndicator(position: Int) {
        var index = 0
        intro_dots_layout.removeAllViews()

        // Change activity background color
        root_view.setBackgroundColor(slides[position].backgroundColor)

        while (index != slides.size) {
            val tvDot = TextView(this)
            tvDot.text = Html.fromHtml("&#8226;")
            tvDot.textSize = 35F
            tvDot.setTextColor(ResourcesCompat.getColor(resources, R.color.intro_white_transparent_color, null))
            intro_dots_layout.addView(tvDot)
            index++
        }

        if (intro_dots_layout.childCount > 0) {
            val currentDot = intro_dots_layout.getChildAt(position) as TextView
            currentDot.setTextColor(ResourcesCompat.getColor(resources, R.color.intro_white_color, null))
        }
    }

    fun addSlide(slide: IntroSlide) {
        checkNotNull(slide)

        slides.add(slide)
    }
}
