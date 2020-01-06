package com.bw.miaoheng20200106.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.miaoheng20200106.base.mvp.BasePresenter;
import com.bw.miaoheng20200106.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 时间 :2020/1/6  8:47
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    //声明对象
    public P presenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutid());
        //ButterKnife绑定
        bind = ButterKnife.bind(this);
        //初始化p层对象
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int bindLayoutid();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (presenter != null) {
            presenter.deattach();   //解决内存泄露
        }
        //ButterKnife的解绑
        if (bind != null) {
            bind.unbind();
        }
    }
}
