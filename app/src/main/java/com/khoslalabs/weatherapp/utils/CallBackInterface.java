package com.khoslalabs.weatherapp.utils;

public interface CallBackInterface {
    void onSuccessResponse(Object o, String key);
    void onErrorResponse(Object o, String key);
}
