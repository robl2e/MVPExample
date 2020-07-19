package com.robl2e.mvpexample.ui.detail

import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LifecycleOwner
import com.robl2e.mvpexample.data.local.DataRepositoryImpl
import com.robl2e.mvpexample.ui.mvp.component.AbstractUIComponent

open class DetailComponent(container: ViewGroup) :
        AbstractUIComponent<DetailContract.View, DetailContract.Presenter>(), DetailContract.ViewListener {

    override var view = initView(container)
    override var presenter = initPresenter()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    open fun initView(container: ViewGroup): DetailContract.View {
        return DetailMvpViewImpl(container)
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    open fun initPresenter(): DetailContract.Presenter {
        return DetailPresenter(DataRepositoryImpl())
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        view.registerListener(this)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        view.unregisterListener(this)
    }

    override fun onEvent(event: DetailContract.ViewEvent) {
        when (event) {
            is DetailContract.ViewEvent.ButtonClick -> {
                presenter.loadData()
            }
        }
    }
}