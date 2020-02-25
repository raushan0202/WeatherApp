package com.khoslalabs.weatherapp;

import android.app.Application;

import com.khoslalabs.weatherapp.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class MainRepository {
    private ArrayList<Movie> movies=new ArrayList<>();
    private MutableLiveData<List<WeatherModel>> mutableLiveData=new MutableLiveData<>();
    private Application application;

}
