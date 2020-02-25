package com.khoslalabs.weatherapp.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParsingUtil {
    public static Object parseJson(APIEndpoint endpoint,String responseStr){
        try {
            Class<?> classType = endpoint.getResponseModel();
            Object obj;
            JSONObject jsonObject = new JSONObject(responseStr);
            switch (endpoint){
                case GET_CURRENT_WEATHER:
                    obj = new Gson().fromJson(jsonObject.toString(),TypeToken.get(classType).getType());
                    return obj;


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
