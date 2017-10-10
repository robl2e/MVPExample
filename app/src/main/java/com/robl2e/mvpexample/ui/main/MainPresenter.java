package com.robl2e.mvpexample.ui.main;

import com.robl2e.mvpexample.data.ResponseHandler;
import com.robl2e.mvpexample.data.local.DataRepository;
import com.robl2e.mvpexample.data.model.Data;
import com.robl2e.mvpexample.ui.mvp.AbstractPresenter;

/**
 * Created by robl2e on 10/9/17.
 */

class MainPresenter extends AbstractPresenter<MainContract.MvpView> implements MainContract.Presenter {

    private final DataRepository dataRepository;

    MainPresenter(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void loadData() {
        // Simulate getting data
        dataRepository.getData(new ResponseHandler<Data>() {
            @Override
            public void onComplete(Data data) {
                getView().displayProgressIndicator(false);
                getView().renderData(data);
            }
        });

    }
}
