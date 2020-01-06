package com.bw.miaoheng20200106.base.mvp;

import java.lang.ref.WeakReference;

/**
 * 时间 :2020/1/6  8:45
 * 作者 :苗恒
 * 功能 :  p层
 */
public abstract class BasePresenter<M extends IBaseModel ,V extends IBaseView> {
     public M model;
     public WeakReference<V> weakReference;

    public BasePresenter(){
        //在构造方法内初始化m层
        model=initModel();
    }
    //绑定
  public void attach(V v){
        weakReference=new WeakReference<>(v);
  }
  //解绑
  public void  deattach(){
      if (weakReference != null) {
          weakReference.clear();
          weakReference=null ;
      }
  }
  //对外提供暴露方法  获取v层实例
  public V getView(){
        return weakReference.get();
  }
    protected abstract M initModel();
}
