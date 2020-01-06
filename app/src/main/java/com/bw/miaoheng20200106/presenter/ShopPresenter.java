package com.bw.miaoheng20200106.presenter;

import com.bw.miaoheng20200106.base.mvp.BasePresenter;
import com.bw.miaoheng20200106.contract.IShopContract;
import com.bw.miaoheng20200106.model.ShopModel;

import java.util.HashMap;

/**
 * 时间 :2020/1/6  9:07
 * 作者 :苗恒
 * 功能 :p层
 */
public class ShopPresenter extends BasePresenter<ShopModel, IShopContract.IView> implements IShopContract.IPresenter {
    /**
     * 初始化m层对象
     * @return
     */
    @Override
    protected ShopModel initModel() {
        return new ShopModel();
    }

    @Override
    public void getTagData() {
       model.getTagData(new IShopContract.IModel.ModelCallBack() {
           @Override
           public void seccess(Object data) {
               //获取m层的数据传递给v层
               getView().seccess(data);
           }

           @Override
           public void failure(Throwable throwable) {
                   getView().failure(throwable);
           }
       });
    }

    @Override
    public void getShopData(HashMap<String, String> params) {
        model.getShopData(params, new IShopContract.IModel.ModelCallBack() {
            @Override
            public void seccess(Object data) {
                //获取m层的数据传递给v层
                 getView().seccess(data);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }
}
