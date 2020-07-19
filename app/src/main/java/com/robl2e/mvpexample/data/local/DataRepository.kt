package com.robl2e.mvpexample.data.local


import android.os.AsyncTask

import com.robl2e.mvpexample.data.ResponseHandler
import com.robl2e.mvpexample.data.model.Data

/**
 * Created by robl2e on 10/9/17.
 */

interface DataRepository {
    fun getData(responseHandler: ResponseHandler<Data>?)
}

class DataRepositoryImpl : DataRepository{
    // Simulate getting data
    override fun getData(responseHandler: ResponseHandler<Data>?) {
        object : AsyncTask<Void, Void, Data>() {
            override fun doInBackground(vararg voids: Void): Data {
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                return Data("Data Received: " + System.currentTimeMillis())
            }

            override fun onPostExecute(data: Data) {
                super.onPostExecute(data)
                responseHandler?.onComplete(data)
            }
        }.execute()
    }
}
