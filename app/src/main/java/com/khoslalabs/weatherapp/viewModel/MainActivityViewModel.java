package com.khoslalabs.weatherapp.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.khoslalabs.weatherapp.MainRepository;

public class MainActivityViewModel extends AndroidViewModel {
    private MainRepository mainRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mainRepository=new MainRepository(application);
    }
}
