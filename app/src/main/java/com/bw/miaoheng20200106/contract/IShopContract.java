package com.bw.miaoheng20200106.contract;

import com.bw.miaoheng20200106.base.mvp.IBaseModel;
import com.bw.miaoheng20200106.base.mvp.IBaseView;

import java.util.HashMap;

/**
 * 时间 :2020/1/6  8:51
 * 作者 :苗恒
 * 功能 :  契约类统一管理接口
 */
public interface IShopContract {
    interface IModel extends IBaseModel {

        void getTagData(ModelCallBack modelCallBack);  //获取左侧分类信息
        void getShopData(HashMap<String,String> params,ModelCallBack modelCallBack);  //获取右侧商品信息展示
        interface ModelCallBack{
            void seccess(Object data);   //成功的回调
            void failure(Throwable throwable);   //失败的回调
        }
    }
    interface IView extends IBaseView {
        void seccess(Object data);   //成功
        void failure(Throwable throwable);  //失败
    }
    interface IPresenter{
        void getTagData();    //获取左侧分类信息
        void getShopData(HashMap<String,String> params);//获取右侧商品信息展示
    }
}
