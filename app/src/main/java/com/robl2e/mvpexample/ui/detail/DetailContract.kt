package com.robl2e.mvpexample.ui.detail

import com.robl2e.mvpexample.data.model.Data
import com.robl2e.mvpexample.ui.mvp.MvpBasePresenter
import com.robl2e.mvpexample.ui.mvp.soloview.ObservableSoloMvpView
import com.robl2e.mvpexample.ui.mvp.view.BaseViewListener

interface DetailContract {

    interface View : ObservableSoloMvpView<ViewListener> {
        fun render(state : ViewState)
    }

    interface Presenter : MvpBasePresenter<View> {
        fun loadData()
    }

    interface ViewListener : BaseViewListener<ViewEvent>

    sealed class ViewEvent {
        object ButtonClick : ViewEvent()
    }

    sealed class ViewState {
        data class LoadingState(val loading : Boolean) : ViewState()
        data class DataState(val data: Data) : ViewState()
    }
}