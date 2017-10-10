package com.robl2e.mvpexample.data.local;


import android.os.AsyncTask;

import com.robl2e.mvpexample.data.ResponseHandler;
import com.robl2e.mvpexample.data.model.Data;

/**
 * Created by robl2e on 10/9/17.
 */

public class DataRepository {
    // Simulate getting data
    public void getData(final ResponseHandler<Data> responseHandler) {
        new AsyncTask<Void, Void, Data>() {
            @Override
            protected Data doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return new Data("Data Received: " + System.currentTimeMillis());
            }

            @Override
            protected void onPostExecute(Data data) {
                super.onPostExecute(data);
                if (responseHandler != null) {
                    responseHandler.onComplete(data);
                }
            }
        }.execute();
    }
}
