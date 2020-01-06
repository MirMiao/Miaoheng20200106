package com.bw.miaoheng20200106.utils;

import com.bw.miaoheng20200106.api.Api;

import javax.xml.transform.OutputKeys;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间 :2020/1/6  8:57
 * 作者 :苗恒
 * 功能 :
 */
public class RetrofitUtlis {

    private static RetrofitUtlis retrofitUtlis;
    private final Retrofit retrofit;

    private RetrofitUtlis() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//添加日志拦截器
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()) //消息转换
                .build();
    }

    public static RetrofitUtlis getInstance() {
        if(retrofitUtlis==null){
            synchronized (RetrofitUtlis.class){
                if(retrofitUtlis==null){
                    retrofitUtlis=new RetrofitUtlis();
                }
            }
        }
        return retrofitUtlis;
    }
    public <T>T creatService(Class<T> tClass){
        T t = retrofit.create(tClass);
        return t;
    }
}
