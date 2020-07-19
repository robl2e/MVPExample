package com.robl2e.mvpexample.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.robl2e.mvpexample.R
import com.robl2e.mvpexample.data.model.Data
import com.robl2e.mvpexample.ui.mvp.soloview.AbstractObservableSoloMvpView

class DetailMvpViewImpl(container: ViewGroup) : AbstractObservableSoloMvpView<DetailContract.ViewListener>()
        , DetailContract.View, View.OnClickListener {

    private var progressIndicator: ProgressBar
    private var dataTextView: TextView
    private var loadDataButton: Button
    private var rootView: View = LayoutInflater.from(container.context)
            .inflate(R.layout.layout_detail_view, container, false)

    init {
        container.addView(rootView)

        progressIndicator = rootView.findViewById<View>(R.id.progress_indicator) as ProgressBar
        dataTextView = rootView.findViewById<View>(R.id.text_data) as TextView
        loadDataButton = rootView.findViewById<View>(R.id.button_load) as Button
        loadDataButton.setOnClickListener(this)
    }

    override fun getRootView(): View? {
        return rootView
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_load -> {
                notifyListeners(DetailContract.ViewEvent.ButtonClick)
            }
        }
    }

    private fun notifyListeners(event : DetailContract.ViewEvent) {
        for (listener in getListeners()) {
            listener.onEvent(event)
        }
    }

    override fun render(state: DetailContract.ViewState) {
        when (state) {
            is DetailContract.ViewState.DataState -> {
                renderLoadingView(false)
                renderData(state.data)
            }
            is DetailContract.ViewState.LoadingState -> {
                renderLoadingView(state.loading)
            }
        }
    }

    private fun renderData(data: Data) {
        dataTextView.visibility = View.VISIBLE
        dataTextView.text = data.text
    }

    private fun renderLoadingView(show: Boolean) {
        progressIndicator.visibility = if (show) View.VISIBLE else View.GONE
    }
}