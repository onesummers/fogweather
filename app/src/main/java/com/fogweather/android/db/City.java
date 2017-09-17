package com.fogweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/9/17.
 */

public class City extends DataSupport {
    private  int id ;
    private  String cityName ;
    private  int cityCode ;
    private int provincId ;
    public  int getId(){
        return id ;
    }
    public void setId(int id){
        this.id = id ;
    }

    public String getcityName(){
        return  cityName ;
    }
    public void setcityName(String cityName){
        this.cityName = cityName;
    }

    public int getcityCode(){
        return cityCode;
    }

    public void setcityCode(){
        this.cityCode = cityCode ;
    }

    public void setProvinceId(int provinceId){
        this.provincId = provinceId ;
    }
    public int getProvincId(){
        return provincId ;
    }
}
