package com.robl2e.mvpexample.ui.mvp.soloview

import android.view.View
import com.robl2e.mvpexample.ui.mvp.MvpBaseView

interface SoloMvpView : MvpBaseView {
    fun getRootView(): View?
}