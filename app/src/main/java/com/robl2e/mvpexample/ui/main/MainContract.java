package com.robl2e.mvpexample.ui.main;

import com.robl2e.mvpexample.data.model.Data;
import com.robl2e.mvpexample.ui.mvp.MvpBasePresenter;
import com.robl2e.mvpexample.ui.mvp.MvpBaseView;

/**
 * Created by robl2e on 10/9/17.
 */

interface MainContract {
    interface MvpView extends MvpBaseView{
        void renderData(Data data);
        void displayProgressIndicator(boolean show);
    }

    interface Presenter extends MvpBasePresenter<MvpView> {
        void loadData();
    }
}
