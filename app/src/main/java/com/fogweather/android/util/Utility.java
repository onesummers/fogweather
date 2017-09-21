package com.fogweather.android.util;

import org.json.JSONArray;
import org.json.JSONObject ;
import org.json.JSONException ;
import android.text.TextUtils ;

import com.fogweather.android.db.City;
import com.fogweather.android.db.Country;
import com.fogweather.android.db.Province ;
import com.fogweather.android.gson.Weather;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/9/17.
 */

public class Utility {

    // 用下面三个方法解析了省市县级数据
    // 先用JSONArray和JSONObject将数据解析出来，然后组装成实体类对象
    // 再调用save()方法将数据保存到数据库中
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if( !TextUtils.isEmpty(response)) {
            try{
                JSONArray allProvinces = new JSONArray(  response) ;
                for ( int i = 0; i < allProvinces.length(); i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i) ;
                    Province province = new Province() ;
                    province.setProvinceName(provinceObject.getString("name")) ;
                    province.setProvinceCode(provinceObject.getInt("id")) ;
                    province.save() ;
                }
                return true ;
            }catch (JSONException e){
                e.printStackTrace() ;
            }
        }
        return false ;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if( !TextUtils.isEmpty(response)) {
            try{
                JSONArray allCities = new JSONArray(  response) ;
                for ( int i = 0; i < allCities.length(); i++){
                    JSONObject cityObject = allCities.getJSONObject(i) ;
                    City city = new City() ;
                    city.setCityName(cityObject.getString("name")) ;
                    city.setCityCode(cityObject.getInt("id")) ;
                    city.setProvinceId(provinceId);
                    city.save() ;
                }
                return true ;
            }catch (JSONException e){
                e.printStackTrace() ;
            }
        }
        return false ;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if( !TextUtils.isEmpty(response)) {
            try{
                JSONArray allCounties = new JSONArray(  response) ;
                for ( int i = 0; i < allCounties.length(); i++){
                    JSONObject countyObject = allCounties.getJSONObject(i) ;
                    Country county = new Country() ;
                    county.setCountryName(countyObject.getString("name")) ;
                    county.setWeatherId(countyObject.getString("weather_id")); ;
                    county.setCityId(cityId);
                    county.save() ;
                }
                return true ;
            }catch (JSONException e){
                e.printStackTrace() ;
            }
        }
        return false ;
    }

    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response) ;
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather") ;
            String weatherContent = jsonArray.getJSONObject(0).toString() ;
            return new Gson().fromJson(weatherContent,Weather.class) ;
        }catch ( Exception e){
            e.printStackTrace();
        }
        return null ;
    }
}


