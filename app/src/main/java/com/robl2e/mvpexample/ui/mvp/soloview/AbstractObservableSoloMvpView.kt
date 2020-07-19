package com.robl2e.mvpexample.ui.mvp.soloview

import com.robl2e.mvpexample.infrastructure.observable.Observable

abstract class AbstractObservableSoloMvpView<LISTENER> : AbstractSoloMvpView(),
        ObservableSoloMvpView<LISTENER> {

    private val observableDelegate = Observable.Factory.create<LISTENER>()

    override fun registerListener(listener: LISTENER) {
        observableDelegate.registerListener(listener)
    }

    override fun unregisterListener(listener: LISTENER) {
        observableDelegate.unregisterListener(listener)
    }

    override fun getListeners(): Set<LISTENER> {
        return observableDelegate.getListeners()
    }
}