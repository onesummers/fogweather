package com.fogweather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/9/17.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        // 实现和服务器交互
        // 按照下面的交互完成后，发起一条HTTp请求只需要调用sendOkHttpRequest()方法，传入请求地址，并注册一个回调来处理服务器响应就行了
        OkHttpClient client = new OkHttpClient() ;
        Request request = new Request.Builder().url(address).build() ;
        client.newCall(request).enqueue(callback) ;
    }
}
