package com.khoslalabs.weatherapp.utils;

import com.khoslalabs.weatherapp.models.WeatherModel;

import okhttp3.MediaType;

public enum APIEndpoint {
    GET_CURRENT_WEATHER;



    public String getUrl() {
        switch (this) {
            case GET_CURRENT_WEATHER: return "http://api.weatherstack.com/current?access_key=6be63a2238061296bb9dd22398cb4a2d&query=BANGALORE";
        }
        return "";
    }

    public MediaType getMediaType(){
        final MediaType JSON
                = MediaType.get("application/json; charset=utf-8");
        return JSON;
    }

    public Class<?> getResponseModel() {
        switch (this){
            case GET_CURRENT_WEATHER:return WeatherModel.class;
        }
        return null;
    }

}
