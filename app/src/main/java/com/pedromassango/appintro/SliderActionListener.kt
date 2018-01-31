package com.pedromassango.appintro

/**
 * Created by Pedro Massango on 1/27/18.
 */
interface SliderActionListener {
    fun onBack(slide: IntroSlide)
    fun onNext(slide: IntroSlide)
    fun onFinish(slide: IntroSlide)
}