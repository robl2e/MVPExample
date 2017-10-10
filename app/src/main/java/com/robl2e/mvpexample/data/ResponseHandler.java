package com.robl2e.mvpexample.data;

/**
 * Created by robl2e on 10/9/17.
 */

public interface ResponseHandler<DATA> {
    void onComplete(DATA data);
}
