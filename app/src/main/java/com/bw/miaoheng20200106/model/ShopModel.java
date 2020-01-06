package com.bw.miaoheng20200106.model;

import com.bw.miaoheng20200106.api.DataApiService;
import com.bw.miaoheng20200106.api.TagApiService;
import com.bw.miaoheng20200106.contract.IShopContract;
import com.bw.miaoheng20200106.entity.DataEntity;
import com.bw.miaoheng20200106.entity.TagEntity;
import com.bw.miaoheng20200106.utils.RetrofitUtlis;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间 :2020/1/6  9:04
 * 作者 :苗恒
 * 功能 :   m层
 */
public class ShopModel implements IShopContract.IModel {
    /**
     * 获取左侧分类
     * @param modelCallBack
     */
    @Override
    public void getTagData(ModelCallBack modelCallBack) {
        RetrofitUtlis.getInstance().creatService(TagApiService.class)
                .getTag()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())  //切换到主线程
                .subscribe(new Observer<TagEntity>() {    //订阅
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TagEntity tagEntity) {
                      //成功
                        modelCallBack.seccess(tagEntity);
                    }
                        //失败
                    @Override
                    public void onError(Throwable e) {
                      modelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取右侧商品信息
     * @param params
     * @param modelCallBack
     */
    @Override
    public void getShopData(HashMap<String, String> params, ModelCallBack modelCallBack) {
             RetrofitUtlis.getInstance().creatService(DataApiService.class)
                     .getData(params)
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Observer<DataEntity>() {
                         @Override
                         public void onSubscribe(Disposable d) {

                         }

                         /**
                          * 成功
                          * @param dataEntity
                          */
                         @Override
                         public void onNext(DataEntity dataEntity) {
                            modelCallBack.seccess(dataEntity);
                         }

                         /**
                          * 失败
                          * @param e
                          */
                         @Override
                         public void onError(Throwable e) {
                             modelCallBack.failure(e);
                         }

                         @Override
                         public void onComplete() {

                         }
                     });
    }
}
