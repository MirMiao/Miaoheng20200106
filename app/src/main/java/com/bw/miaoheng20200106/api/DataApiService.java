package com.bw.miaoheng20200106.api;

import com.bw.miaoheng20200106.entity.DataEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 时间 :2020/1/6  9:23
 * 作者 :苗恒
 * 功能 :  请求商品信息的接口
 */
public interface DataApiService {
    @GET(Api.SHOP_URL)
    Observable<DataEntity> getData(@QueryMap HashMap<String,String> params);
}
