package com.khoslalabs.weatherapp.models;

import android.location.Location;

public class WeatherModel {
    //private Request request;
    private Location location;
    private CurrentModel current;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentModel getCurrent() {
        return current;
    }

    public void setCurrent(CurrentModel current) {
        this.current = current;
    }
}
