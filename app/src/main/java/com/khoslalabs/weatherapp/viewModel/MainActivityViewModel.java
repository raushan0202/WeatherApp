package com.khoslalabs.weatherapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.khoslalabs.weatherapp.MainRepository;
import com.khoslalabs.weatherapp.models.WeatherModel;

public class MainActivityViewModel extends AndroidViewModel {
    private MainRepository mainRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mainRepository=new MainRepository(application);
        callWeatherAPI();
    }

    public MutableLiveData<WeatherModel> fetchWeatherData(){
        return mainRepository.getWeatherData();
    }

    public void callWeatherAPI(){
        mainRepository.getUpdatedWeatherData(null);
    }

}
