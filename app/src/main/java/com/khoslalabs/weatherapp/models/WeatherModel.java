package com.khoslalabs.weatherapp.models;


public class WeatherModel {
    //private Request request;
    private LocationModel location;
    private CurrentModel current;

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public CurrentModel getCurrent() {
        return current;
    }

    public void setCurrent(CurrentModel current) {
        this.current = current;
    }
}
