package com.fogweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/19.
 */

public class Weather {
    public String status ;
    public Basic basic ;
    public AQI aqi ;
    public Now now ;
    public Suggestion suggestion ;
    @SerializedName("daily_forecast")
    public ArrayList<Forecast> forecastList ;
}
