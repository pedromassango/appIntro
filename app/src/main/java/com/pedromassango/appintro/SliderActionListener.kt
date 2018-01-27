package com.pedromassango.appintro

/**
 * Created by Pedro Massango on 1/27/18.
 */
interface SliderActionListener {
    fun onBack(slideIndex: Int)
    fun onNext(slideIndex: Int)
    fun onFinish(slideIndex: Int)
}