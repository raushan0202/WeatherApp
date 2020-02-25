package com.khoslalabs.weatherapp;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.khoslalabs.weatherapp.models.WeatherModel;
import com.khoslalabs.weatherapp.utils.APIEndpoint;
import com.khoslalabs.weatherapp.utils.CallBackInterface;
import com.khoslalabs.weatherapp.utils.NetworkUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class MainRepository implements CallBackInterface {
    private ArrayList<WeatherModel> weatherModels=new ArrayList<>();
    private MutableLiveData<WeatherModel> mutableLiveData=new MutableLiveData<>();
    private Application application;


    public MainRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<WeatherModel> getWeatherData(){
        return mutableLiveData;
    }

    public void getUpdatedWeatherData(HashMap<String,String> queryParams){
        NetworkUtil.callAPI(APIEndpoint.GET_CURRENT_WEATHER,this,queryParams);
    }

    @Override
    public void onSuccessResponse(Object o, String key) {
        if (key.equalsIgnoreCase(APIEndpoint.GET_CURRENT_WEATHER.toString()) ){
            if (o instanceof WeatherModel){
                mutableLiveData.postValue((WeatherModel) o);
            }
        }
    }

    @Override
    public void onErrorResponse(Object o, String key) {

    }
}
