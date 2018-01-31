package com.pedromassango.appintro

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_intro.view.*

/**
 * Created by Pedro Massango on 1/26/18.
 */
class SliderAdapter(private val introSlides: MutableList<IntroSlide>) : PagerAdapter() {

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object` as LinearLayout
        //return true
    }

    override fun getCount(): Int = introSlides.size

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val inflater = container!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.fragment_intro, container, false)

        with(view) {
            with(introSlides[position]) {
                intro_title.text = mTitle
                intro_description.text = mDescription
                intro_icon.setImageResource(mIcon)
            }
        }

        // Set the view on layout
        container.addView( view)

        return view
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container!!.removeView( `object` as LinearLayout)
    }
}