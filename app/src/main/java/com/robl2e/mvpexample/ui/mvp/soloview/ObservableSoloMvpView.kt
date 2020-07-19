package com.robl2e.mvpexample.ui.mvp.soloview

import com.robl2e.mvpexample.infrastructure.observable.Observable

interface ObservableSoloMvpView<LISTENER> : Observable<LISTENER>, SoloMvpView{
}