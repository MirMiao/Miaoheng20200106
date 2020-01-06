package com.bw.miaoheng20200106.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 时间 :2020/1/6  9:44
 * 作者 :苗恒
 * 功能 :
 */
public class NetUtils {
    private static NetUtils netUtils=new NetUtils();

    private NetUtils() {
    }

    public static NetUtils getInstance() {
        return netUtils;
    }
    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null &&activeNetworkInfo.isAvailable()) {
            return true;
        }else{
            return false;
        }
    }
}
