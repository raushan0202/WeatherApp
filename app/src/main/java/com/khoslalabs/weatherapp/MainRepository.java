package com.khoslalabs.weatherapp;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.khoslalabs.weatherapp.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class MainRepository {
    private ArrayList<WeatherModel> weatherModels=new ArrayList<>();
    private MutableLiveData<WeatherModel> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public MainRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<WeatherModel> getMutableLiveData(){

    }


}
