package com.jasonkung.springboot;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ParkingProvider {

    public static String get(String url) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

}
