package com.robl2e.mvpexample.ui.mvp.view

interface BaseViewListener<EVENT> {
    fun onEvent(event: EVENT)
}