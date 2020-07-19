package com.robl2e.mvpexample.ui.detail

import com.robl2e.mvpexample.data.ResponseHandler
import com.robl2e.mvpexample.data.local.DataRepository
import com.robl2e.mvpexample.ui.mvp.AbstractPresenter

class DetailPresenter(private val dataRepository: DataRepository)
    : AbstractPresenter<DetailContract.View>(), DetailContract.Presenter{

    override fun loadData() {
        view?.render(DetailContract.ViewState.LoadingState(true))

        // Simulate getting data
        dataRepository.getData(ResponseHandler{
            data -> view?.render(DetailContract.ViewState.DataState(data))
        })
    }

}