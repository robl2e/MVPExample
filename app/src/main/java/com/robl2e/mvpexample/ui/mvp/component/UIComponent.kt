package com.robl2e.mvpexample.ui.mvp.component

import com.robl2e.mvpexample.ui.mvp.MvpBasePresenter
import com.robl2e.mvpexample.ui.mvp.MvpBaseView

interface UIComponent<V : MvpBaseView, P : MvpBasePresenter<V>> {
    var view: V
    var presenter: P
}