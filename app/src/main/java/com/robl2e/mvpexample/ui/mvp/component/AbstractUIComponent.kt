package com.robl2e.mvpexample.ui.mvp.component

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.robl2e.mvpexample.ui.mvp.MvpBasePresenter
import com.robl2e.mvpexample.ui.mvp.MvpBaseView

abstract class AbstractUIComponent<V : MvpBaseView, P : MvpBasePresenter<V>>
    : UIComponent<V, P>, DefaultLifecycleObserver{

    override fun onCreate(owner: LifecycleOwner) {
        presenter.attachView(view)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        presenter.detachView(false)
    }
}