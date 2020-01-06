package com.bw.miaoheng20200106.api;

import com.bw.miaoheng20200106.entity.TagEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 时间 :2020/1/6  9:04
 * 作者 :苗恒
 * 功能 :获取左侧分类的接口
 */
public interface TagApiService {

    @GET(Api.TAG_URL)
    Observable<TagEntity> getTag();
}
