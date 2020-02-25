package com.khoslalabs.weatherapp.utils;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NetworkUtil {

    private static NetworkUtil instance;
    private OkHttpClient client;

    private NetworkUtil() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .dispatcher(new Dispatcher())
                .build();
    }

    private static NetworkUtil getInstance() {
        if (instance == null) instance = new NetworkUtil();
        return instance;
    }

    public static void callAPI(APIEndpoint endpoint, CallBackInterface callback, HashMap<String, String> queryParams) {
        try {
            HttpUrl.Builder httpUrlBuilder = HttpUrl.parse(endpoint.getUrl()).newBuilder();

            if (queryParams != null && !queryParams.isEmpty()) {
                for (String key : queryParams.keySet()) {
                    httpUrlBuilder.addQueryParameter(key, queryParams.get(key));
                }
            }
            HttpUrl httpUrl = httpUrlBuilder.build();

            NetworkUtil util = getInstance();
            Request request = null;
            request = new Request.Builder()
                    .url(httpUrl)
                    .build();


            util.client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("onFailure", e.toString());
                    callback.onErrorResponse(e.getMessage(), endpoint.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        if (response != null) {
                            String responseStr;
                            ResponseBody responseBody = response.body();
                            if (response.isSuccessful() && responseBody != null) {
                                responseStr = responseBody.string();
                                Log.d("NetworkUtil ==> ", "Response : " + responseStr);
                                callback.onSuccessResponse(ParsingUtil.parseJson(endpoint, responseStr), endpoint.toString());

                            } else {
                                Response networkResponse = response.networkResponse();
                                if (networkResponse != null) {
                                    callback.onErrorResponse(response.body().string(), endpoint.toString());
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}

