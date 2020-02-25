package com.khoslalabs.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.khoslalabs.weatherapp.databinding.ActivityMainBinding;
import com.khoslalabs.weatherapp.models.WeatherModel;
import com.khoslalabs.weatherapp.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);

        setObserver();

        activityMainBinding.swipeLayout.setColorSchemeResources(R.color.colorPrimary);
        activityMainBinding.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    private void setObserver() {
        mainActivityViewModel.fetchWeatherData().observe(this, new Observer<WeatherModel>() {
            @Override
            public void onChanged(WeatherModel weatherModel) {

            }
        });
    }
}
