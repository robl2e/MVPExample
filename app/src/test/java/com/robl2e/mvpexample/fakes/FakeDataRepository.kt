package com.robl2e.mvpexample.fakes

import com.robl2e.mvpexample.data.ResponseHandler
import com.robl2e.mvpexample.data.local.DataRepository
import com.robl2e.mvpexample.data.model.Data

class FakeDataRepository : DataRepository {
    override fun getData(responseHandler: ResponseHandler<Data>?) {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        responseHandler?.onComplete(Data("Data Received: " + System.currentTimeMillis()))
    }
}